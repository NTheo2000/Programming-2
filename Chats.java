/*
 * Class Chats
 * 
 * This class performs all the operations related to a chat, which refers to the
 * communication of the employees.
 * 
 * Contains methods that create the chat database using a json formed file, add or 
 * delete members, add administrators, send messages and show the chat history.
 * 
 * @date 8 Dec 19
 * @author Michael-Dontas
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Chats {
	private static JSONArray chat_list = new JSONArray();
	/*
	 * Reads the JSONArray object that is stored in the json file
	 * and puts it in the static JSONArray chat_list.
	 * 
	 * @param filename the name of the json file
	 */
	private static void readList(String filename) 
			throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		chat_list = (JSONArray) parser.parse(new FileReader("Chats.json"));
	}
	/* 
	 * Creates an empty chat with the parameters that are given.
	 * 
	 * @param members_id the ids of the members of the chat
	 * @param chat_name the name of the new chat
	 * @param creator_id the id of the creator of the chat
	 * 
	 * @return a message regarding the result of the chat creation
	 */
	public static String createChat(String[] members_id, String chat_name, String creator_id) {
		String message = null;
		try {
			readList("Chats.json");
		} catch (FileNotFoundException e) {
			File file = new File("Chats.json");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				message = "An error has occured. Please try again.";
			}
		} catch (Exception e) {
			message = "An error has occured. Please try again.";
		}
		if (notcontainsName(members_id, chat_name)) {
			try {
				createChatJSONObject(members_id, chat_name, creator_id);
				message = "New chat was successfully created";
			} catch (IOException e) {
				message = "An error has occured. Please try again.";
			}
		} else {
			message = "This chat name already exists for one or more of your memebrs. "
								+ "Please try another name.";
		}
		return message;
	}
	/*
	 * Checks the chat_list to find if a chat name that contains 
	 * the given users exists in the chat database.
	 * 
	 *  @param members_id the ids of the members of the requested chat
	 *  @param chat_name the requested chat name
	 *  
	 *  @return true if the database contains that chat, false, if not 
	 */
	private static boolean notcontainsName(String[] members_id, String chat_name) {
		boolean quit = true;
		JSONObject chat_obj = new JSONObject();
		JSONObject ids_object = new JSONObject();
		for (Object chat : chat_list) {
			chat_obj = (JSONObject) chat;
			if (chat_obj.get("chat_name").equals(chat_name)) {
				ids_object = (JSONObject) chat_obj.get("members_id");
				ArrayList<String> ids = new ArrayList<String>();
				for (int i = 0; i < ids_object.size(); i++) {
					ids.add((String) ids_object.get("member " + (i + 1)));
				}
				for (String id : members_id) {
					if (ids.contains(id)) {
						quit = false;
						break;
					}
				}
			}
			if (!quit) break;
		}
		return quit;
	}
	/*
	 * Adds the list that has been edited by another method to the chat database.
	 * 
	 */
	private static void addEditedListToFile() throws IOException {
		FileWriter writer = new FileWriter("Chats.json");
		writer.write(chat_list.toJSONString());
		writer.flush();  
        writer.close();
	}
	/*
	 * Turns a 1-d Array object into a JSONObject
	 * 
	 * @param array the array to be converted
	 * @param name_of_elements the name for the keys of the new JSONObject
	 * 
	 * @return the converted JSONObject
	 * @see JSONObject
	 */
	@SuppressWarnings("unchecked")
	private static JSONObject makeArrayJSONObject(Object[] array, String name_of_elements) {
		JSONObject obj = new JSONObject();
		for (int i = 0; i < array.length; i++) {
			if(array[i] != null) {
				obj.put(name_of_elements + (i + 1), array[i]);
			}
		}
		return obj;
	}
	/*
	 * This method is used to add a new chat to the chat database
	 * 
	 * Creates a JSONObject using the attributes of the new chat to be created.
	 * Then adds the new JSONObject to the chat_list and stores the edited list
	 * to the file.
	 * 
	 * @param members_id the ids of the members of the new chat
	 * @param chat_name the name of the new chat
	 * @param creator_id the id of the creator of the new chat 
	 */
	@SuppressWarnings({ "unchecked" })
	private static void createChatJSONObject(String[] members_id, String chat_name, String creator_id)
			throws IOException {
		String[] admins = {creator_id};
		String[] full_members = new String[members_id.length + 1];
		for (int i = 0; i < members_id.length; i++) {
			full_members[i] = members_id[i];
		}
		full_members[members_id.length] = creator_id;
		JSONObject chat_obj = new JSONObject();
		JSONObject each_member = makeArrayJSONObject(full_members, "member ");
		JSONObject each_admin = makeArrayJSONObject(admins, "admin ");
		JSONObject each_chat_history = new JSONObject();
		each_chat_history.put("id", creator_id);
		each_chat_history.put("message", null);
		JSONArray each_chat_history_list = new JSONArray();
		each_chat_history_list.add((JSONObject) each_chat_history);
		if(chat_list.isEmpty()) {
			chat_obj.put("code", 100000);
		} else {
			chat_obj.put("code", (long) ((JSONObject) chat_list.get(chat_list.size()-1)).get("code") + 1);
		}
		chat_obj.put("members_id", each_member);
		chat_obj.put("chat_name", chat_name);
		chat_obj.put("chat_history", each_chat_history_list);
		chat_obj.put("admins", each_admin);
		chat_list.add(chat_obj);
		addEditedListToFile();
	}
	/*
	 * Checks to see if the user requiring permission to a chat
	 * is listed in the administrators' list, in order for
	 * permission to be granted.
	 * 
	 * @param chat_name the name of the chat
	 * @param user the id of the user requiring permission
	 * 
	 * @return the position of the chat in the chat_list if the
	 * user is an administrator or -1 if he's not.
	 */
	private static int searchforPermission(String chat_name, String user) {
		int pos = -1;
		for (int i = 0; i < chat_list.size(); i++) {
			if (((JSONObject) chat_list.get(i)).get("chat_name").equals(chat_name) &&
				(((JSONObject) ((JSONObject) chat_list.get(i)).get("admins")).containsValue(user))) {
				pos = i;
				break;
			}
		}
		return pos;
	}
	/*
	 * Adds administrators or members to a chat, required that the user that
	 * performs this operation is already an administrator of the chat.
	 * 
	 * @param chat_name the name of the chat
	 * @param user the id of the user
	 * @param new_users the ids of the users to be added
	 * @param admins_or_members requires either the keyword "admin" for administrators
	 * or "member" for members
	 * 
	 * @return an update regarding the result of the new users addition 
	 */
	@SuppressWarnings("unchecked")
	public static String addAdminsOrMembers(String chat_name, String user, String[] new_users, String admins_or_members) {
		String message = null;
		String admin_or_member = null;
		if (admins_or_members.equals("admins")) {
			admin_or_member = "admin ";
			message = "New admins have been successfully added.";
		} else {
			admin_or_member = "member ";
			message = "New members have been successfully added.";
		}
		try {
			readList("Chats.json");
			String[] t = {user};
			if (notcontainsName(t, chat_name)) {
				message = "We're sorry, file has either been deleted or your access is denied.";
			} else {
				int pos = searchforPermission(chat_name, user);
				if (pos == -1) {
					message = "We're sorry, you do not have permission to perform this operation.";
				} else {
					JSONObject users = (JSONObject) ((JSONObject) chat_list.get(pos)).get(admins_or_members);
					String[] total_users = new String[users.size() + new_users.length];
					int counter = 0;
					for (int i = 0; i < users.size(); i++) {
						total_users[counter++] = (String) users.get(admin_or_member + (i + 1));
					}
					for (int i = 0; i < new_users.length; i++) {
						if(!users.containsValue(new_users[i])) {
							total_users[counter++] = new_users[i];
						}
					}
					JSONObject newadmins = makeArrayJSONObject(total_users, admin_or_member);
					((JSONObject) chat_list.get(pos)).replace(admins_or_members, newadmins);
					addEditedListToFile();
				}
			}
		} catch (Exception e) {
			message = "An error has occured here. Please try again.";
		}
		return message;
	}
	/*
	 * Deletes a chat, required that the user performing this operation
	 * has permission to do so.
	 * 
	 * @param chat_name the name of the chat to be deleted
	 * @param user the user performing this operation
	 * 
	 * @return an update regarding the result of the chat deletion 
	 */
	public static String deleteChat(String chat_name, String user) {
		String message = null;
		try {
			readList("Chats.json");
			String[] t = {user};
			if (notcontainsName(t, chat_name)) {
				message = "We're sorry, file has either been deleted or your access is denied.";
			} else {
				int pos = searchforPermission(chat_name, user);
				if (pos == -1) {
					message = "We're sorry, you do not have permission to perform this operation.";
				} else {
					chat_list.remove(chat_list.get(pos));
					addEditedListToFile();
					message = "Chat has been successfully deleted.";
				}
			}
		} catch (Exception e) {
			message = "An error has occured. Please try again.";
		}
		return message;
	}
	/*
	 * Removes members from a chat, required that user performing this operation
	 * has permission to do so.
	 * 
	 * Also a member can leave the chat by providing only his id at the to_delete table,
	 * where permission is not required.
	 * 
	 * @param chat_name the name of the chat
	 * @param user the user performing this operation
	 * @param to_delete a table containing the ids of the members to be deleted from the chat
	 * 
	 * @return an update regarding the result of the operation.
	 */
	@SuppressWarnings("unchecked")
	public static String removeMember(String chat_name, String user, String[] to_delete) {
		String message = "The selected members have been successfully deleted.";
		try {
			readList("Chats.json");
			String[] t = {user};
			if (notcontainsName(t, chat_name)) {
				message = "We're sorry, file has either been deleted or your access is denied.";
			} else {
				int pos = searchforPermission(chat_name, user);
				if (pos == -1) {
					message = "We're sorry, you do not have permission to perform this operation.";
				} else {
					JSONObject members = (JSONObject) ((JSONObject) chat_list.get(pos)).get("members_id");
					JSONObject admins = (JSONObject) ((JSONObject) chat_list.get(pos)).get("admins");
					if (user.equals(to_delete[0]) && to_delete.length == 1) {
						int spot1 = -1;
						int spot2 = -1;
						for (int i = 0; i < members.size(); i++) {
							if (members.get("member " + (i + 1)).equals(user)) {
								spot1 = ++i;
								for (int j = 0; j <  admins.size(); i++) {
									if (admins.get("admin " + (j + 1)).equals(user)) {
										spot2 = ++j;
										break;
									}
								}
								break;
							}
						}
						if (spot1 != -1) {
							members.remove("member " + spot1, user);
							admins.remove("admin " + spot2, user);
							message = "You have successfully quitted permanently from the chat";
						}
					} else {
						int count_null = 0;
						int[] spots = new int[to_delete.length];
						boolean leave = false;
						for (int i = 0; i < to_delete.length; i++) {
							if (admins.containsValue(to_delete[i])) {
								spots[i] = -1;
							} else {
								if (members.containsValue(to_delete[i])) {
									for (int j = 0; j < members.size(); j++) {
										leave = false;
										if (members.get("member " + (j + 1)).equals(to_delete[i])) {
											for (int w = 0; w < spots.length; w++) {
												if (spots[w] == j + 1) {
													leave = true;
													break;
												}
											}
											if (leave) continue;
											spots[i] = j + 1;
											break;
										}
									}
								} else {
									spots[i] = -1;
								}
							}
						}
						for (int i = 0; i < spots.length; i++) {
							if (spots[i] != -1) {
								members.remove("member " + spots[i], to_delete[i]);
							} else {
								count_null++;
							}
						}
						if (count_null == spots.length) {
							message = "The selected members could not be deleted either because you don't have "
									+ "permission or they are not members of the chat.";
						} else if (count_null >= 1) {
							message = "Some members could not be deleted either because you don't have " 
									+ "permission or they are not members of the chat."; 
						}
					}
					((JSONObject) chat_list.get(pos)).replace("members_id", members);
					((JSONObject) chat_list.get(pos)).replace("admins", admins);
					addEditedListToFile();
				}
			}
		} catch (Exception e) {
			message = "An error has occured. Please try again.";
		}
		return message;
	}
	/*
	 * Shows all the previous messages from a specified chat.
	 * 
	 * @param chat_name the name of the chat
	 * @param user the user performing this operation
	 * 
	 * @return an ArrayList of String tables containing all the messages
	 * that were sent to a chat next to the id of the member by whom each
	 * message was sent. 
	 */
	public static ArrayList<String[]> showChatHistory(String chat_name, String user) {
		ArrayList<String[]> messages = new ArrayList<String[]>();
		String[] problems1 = {null, "Chat could not be found"};
		String[] problems2 = {null, "An error has occured. Please try again."};
		JSONObject chat = new JSONObject();
		JSONArray chat_history_list = new JSONArray(); 
		JSONObject message = new JSONObject();
		String[] tofill = new String[2];
		try {
			readList("Chats.json");
			for (Object chat_obj : chat_list) {
				chat = (JSONObject) chat_obj;
				if (chat.get("chat_name").equals(chat_name) &&
						((JSONObject) chat.get("members_id")).containsValue(user)) {
					chat_history_list = (JSONArray) chat.get("chat_history");
					for (Object obj : chat_history_list) {
						message = (JSONObject) obj;
						if (!message.containsValue(null)) {
							tofill[0] = (String) message.get("id");
							tofill[1] = (String) message.get("message");
							messages.add(tofill);
						}
					}
					break;
				}
			}
			if (messages.isEmpty()) messages.add(problems1);
		} catch (Exception e) {
			messages.add(problems2);
		}
		return messages;
	}
	/*
	 * Stores a message sent to a chat from a specified user
	 * into the chat database.
	 * 
	 * @param chat_name the name of the chat
	 * @param user the user performing this operation
	 * @param message the message to be sent
	 * 
	 * @return an update regarding the result of the operation
	 */
	@SuppressWarnings("unchecked")
	public static String sendMessage(String chat_name, String user, String message) {
		String update = "Chat could not be found";
		JSONObject chat = new JSONObject();
		JSONArray chat_history_list = new JSONArray();
		JSONObject new_message = new JSONObject();
		try {
			readList("Chats.json");
			for (Object chat_obj : chat_list) {
				chat = (JSONObject) chat_obj;
				if (chat.get("chat_name").equals(chat_name) &&
						((JSONObject) chat.get("members_id")).containsValue(user)) {
					chat_history_list = (JSONArray) chat.get("chat_history");
					new_message.put("id", user);
					new_message.put("message", message);
					chat_history_list.add(new_message);
					chat.replace("chat_history", chat_history_list);
					addEditedListToFile();
					update = "Message has been succesfully sent.";
					break;
				}
			}
		} catch (Exception e) {
			update = "An error has occured. Please try again.";
		}
		return update;
	}
}
