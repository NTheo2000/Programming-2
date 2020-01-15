**[Εγχειρίδιο χρήσης]{.underline}**

**Περιεχόμενα**

Περιγραφή
εφαρμογής.....................................................................................
1

Τρόπος
εγκατάστασης.......................................................................................
6

**Περιγραφή εφαρμογής**

Η εφαρμογή HumanMasteR δημιουργήθηκε με σκοπό να βοηθήσει τον H-R
manager της επιχείρησης να πραγματοποιεί με πιο γρήγορο και εύκολο τρόπο
της καθημερινές του διεργασίες. Πρόσβαση την εφαρμογή έχουν και οι
διευθυντές και οι εργαζόμενοι του κάθε τμήματος της εταιρίας. Ο κάθε
χρήστης ανάλογα με την ιδιότητά του (Manager,Director,Employee) έχει
πρόσβαση σε ένα εξατομικευμένο μενού.

**Manager Menu**

Ο manager μετά το log-in και εφόσον τα στοιχεία σύνδεσης που έχει
εισάγει είναι σωστά

![](media/image1.png){width="3.7666666666666666in"
height="2.506443569553806in"}

Βρίσκεται στο παρακάτω μενού

![](media/image2.png){width="3.7851377952755905in"
height="2.4833333333333334in"}

1)Η επιλογή Evaluate Candidates δίνει την δυνατότητα στον manager να δει
την αξιολόγηση των υποψηφίων ανάλογα με την θέση και το τμήμα που θα
επιλέξει. Για παράδειγμα αν επιλέξει έναν Marketing Director θα
εμφανιστεί το παρακάτω
μενού:![](media/image3.png){width="5.991666666666666in"
height="1.9166666666666667in"}

Από την παραπάνω λίστα μπορεί να επιλέξει οποιονδήποτε υποψήφιο επιθυμεί
και να τον προσλάβει κατευθείαν ή να τον καλέσει για συνέντευξη.

![](media/image4.png){width="4.758333333333334in"
height="2.8451891951006125in"}

2)Η επιλογή Evaluate Employees δίνει την δυνατότητα στον manager να
αξιολογήσει τον κάθε εργαζόμενο και να ελέγξει την πορεία
του.![](media/image5.png){width="6.0in" height="3.308333333333333in"}

Η πορεία του στην συνέχεια εμφανίζεται και μέσα από charts
![](media/image6.png){width="4.818815616797901in"
height="3.841666666666667in"}

3)Η επιλογή Chats καθιστά εφικτή την επικοινωνία του manager με το
προσωπικό και είναι κοινή για όλους τους χρήστες.

**Employee Menu**

![](media/image7.png){width="6.0in" height="3.8916666666666666in"}

1)  Η επιλογή Your Performance εμφανίζει ένα chart με την απόδοση του
    χρήστη

2)  Η επιλογή Evaluate Director εμφανίζει τις ερωτήσεις του
    ερωτηματολογίου από τις οποίες αξιολογείται ο Director

3)  Η επιλογή Chats καθιστά εφικτή την επικοινωνία του χρήστη με το
    προσωπικό και είναι κοινή για όλους τους χρήστες.

**Manager Menu**

![](media/image8.png){width="5.991666666666666in"
height="3.8583333333333334in"}

1)  Η επιλογή Your Performance εμφανίζει ένα chart με την απόδοση του
    χρήστη.

2)  Η επιλογή Evaluate Director εμφανίζει τις ερωτήσεις του
    ερωτηματολογίου με τις οποίες ο Director αξιολογεί κάθε εργαζόμενο
    του τμήματος.

3)  Η επιλογή Chats καθιστά εφικτή την επικοινωνία του χρήστη με το
    προσωπικό και είναι κοινή για όλους τους χρήστες.

**Τρόπος εγκατάστασης**

Οι προϋποθέσεις για την χρήση της εφαρμογής μας είναι ο χρήστης να έχει
εγκατεστημένο στον υπολογιστή του το apache maven 3.6.3
(<https://maven.apache.org/download.cgi>) και το Java SE Development Kit
8u241(<https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html>).

Μπορείτε να κατεβάσετε την εφαρμογή μας με δύο διαφορετικούς τρόπους. Ο
πρώτος τρόπος περιλαμβάνει την χρήση της γραμμής εντολών του υπολογιστή
σας. Αφού έχετε ανοίξει την γραμμή εντολών πληκτρολογείτε την εντολή:

git clone <https://github.com/NTheo2000/Programming-2.git>

Ο δεύτερος τρόπος αφορά την χειροκίνητη εγκατάσταση του προγράμματος
μέσω της παρακάτω ιστοσελίδας:
[[https://github.com/NTheo2000/Programming-2]{.underline}](https://github.com/NTheo2000/Programming-2) 

Στην συνέχεια επιλέγετε το κουμπί download και μετά download zip. Κάνετε
unzip στον φάκελο της επιλογής σας.

Τέλος για να τρέξετε την εφαρμογή πληκτρολογείτε τις παρακάτω εντολές
στην γραμμή εντολών:

mvn clean

mvn package

java -jar\\target\\HumanMasteR-jar-with-dependencies.jar

Τέλος, για να έχετε πρόσβαση στα στοιχεία των εργαζομένων θα ανοίξετε
στον φάκελο που έχετε δημιουργήσει το αρχείο WorkersDatabase.json.
