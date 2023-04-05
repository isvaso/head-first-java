public class DoctorWorking {

   public static void main(String[] args) {

       Doctor[] docs = new Doctor[6];

       docs[0] = new Surgeon(); //That cuts people
       docs[0].setName("Vitaly Bobrov");
       docs[0].setPosition("Surgeon");
       docs[1] = new Dentist();
       docs[1].setName("Bob Hawk");
       docs[1].setPosition("Dentist");
       docs[2] = new Traumatologist();
       docs[2].setName("Bob Hawk");
       docs[2].setPosition("Traumatologist");
       docs[3] = new Dentist();
       docs[3].setName("Misha Kukin");
       docs[3].setPosition("Dentist");
       docs[4] = new Surgeon();
       docs[4].setName("Bob Cut");
       docs[4].setPosition("Surgeon");
       docs[5] = new Traumatologist();
       docs[5].setName("Timur Jackson");
       docs[5].setPosition("Traumatologist");

       for (Doctor setDoc : docs) {
           String message = setDoc.doctorSays();

//           if (setDoc.getPosition().equals("Dentist")) {
//               Dentist d = (Dentist) setDoc;
//               message = d.doctorSays("BZZZ");

//           }

           if (setDoc.getPosition().equals("Dentist")) {
               setDoc.doctorSays();
           }
           System.out.println(message);
       }
   }
}
