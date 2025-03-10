package za.ac.cput.factory;
/*
        TutorFactory.java
        Author: Devon Daniels 217299822
        Date :15 August 2022
        */

import za.ac.cput.entity.Tutor;
import za.ac.cput.util.GenericHelper;

public class TutorFactory {

    public static Tutor createTutor(String firstName,String middleName, String lastName, String tutorEmail, String tutorPhoneNumber) {
        String tutorID = GenericHelper.generateID();

        Tutor tutor = new Tutor.Builder()
                .setTutorID(tutorID)
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setTutorEmail(tutorEmail)
                .setTutorPhoneNumber(tutorPhoneNumber)

                .build();

        return tutor;
    }
}