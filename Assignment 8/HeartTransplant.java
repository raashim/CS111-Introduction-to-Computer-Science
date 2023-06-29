public class HeartTransplant {
 
   // patient array, each Patient is read from the data file
   private Patient[] patients;
 
   // SurvivabilityByAge array, each rate is read from data file
   private SurvivabilityByAge survivabilityByAge;
 
   // SurvivabilityByCause array, each rate is read from data file
   private SurvivabilityByCause survivabilityByCause;
 
   /*
    * Default constructor
    * Initializes patients to null.
    * Initializes survivabilityByAge to null.
    * Initializes survivabilityByCause to null.
    */
   public HeartTransplant() {
 
       // WRITE YOUR CODE HERE
       patients=null;
       survivabilityByAge=null;
       survivabilityByCause=null;
 
 
   }
 
   /*
    * Returns patients
    */
   public Patient[] getPatients() {
 
       // WRITE YOUR CODE HERE
       return patients;
 
    }
 
   /*
    * Returns survivabilityByAge
    */
   public SurvivabilityByAge getSurvivabilityByAge() {
       // WRITE YOUR CODE HERE
 
       return survivabilityByAge;
   }
 
   /*
    * Returns survivabilityByCause
    */
   public SurvivabilityByCause getSurvivabilityByCause() {
       // WRITE YOUR CODE HERE
 
      return survivabilityByCause;
 
   }
 
   /*
    * 1) Initialize the instance variable patients array with numberOfLines length.
    *
    * 2) Reads from the command line data file, use StdIn.readInt() to read an integer.
    *    File Format:
    *      ID, ethnicity, Gender, Age, Cause, Urgency, State of health
    *
    *    Each line refers to one Patient, all values are integers.
    *
    */
   public void readPatients (int numberOfLines) {
       // WRITE YOUR CODE HERE
 
      
       patients=new Patient[numberOfLines];
       int id=0;
       int ethnicity=0;
       int gender=0;
        int age=0;
        int cause=0;
        int urgency=0;
         int stateOfHealth=0;
 
       for(int i=0; i<patients.length;i++){
           id=StdIn.readInt();
           ethnicity=StdIn.readInt();
           gender=StdIn.readInt();
           age=StdIn.readInt();
           cause=StdIn.readInt();
           urgency=StdIn.readInt();
           stateOfHealth=StdIn.readInt();
 
           Patient patientTemp=new Patient (id,ethnicity,gender,age,cause,urgency,stateOfHealth);
           patients[i]=patientTemp;
 
          
          
       }
   }
 
   /*
    * 1) Initialize the instance variable survivabilityByAge with a new survivabilityByAge object.
    *
    * 2) Reads from the command line file to populate the object.
    *    Use StdIn.readInt() to read an integer and StdIn.readDouble() to read a double.
    *
    *    File Format: Age YearsPostTransplant Rate
    *    Each line refers to one survivability rate by age.
    *
    */
   public void readSurvivabilityByAge (int numberOfLines) {
       // WRITE YOUR CODE HERE
 
     
      int age=0;
      int postTransplantYear=0;
      double rate=0.0;
      survivabilityByAge=new SurvivabilityByAge();
 
      for (int i=0; i<numberOfLines;i++){
       age=StdIn.readInt();
       postTransplantYear=StdIn.readInt();
       rate=StdIn.readDouble();
       survivabilityByAge.addData(age,postTransplantYear,rate);
 
 
 
      }
     
   }
 
   /*
    * 1) Initialize the instance variable survivabilityByCause with a new survivabilityByCause object.
    *
    * 2) Reads from the command line file to populate the object. Use StdIn.readInt() to read an
    *    integer and StdIn.readDouble() to read a double.
    *
    *    File Format: Cause YearsPostTransplant Rate
    *    Each line refers to one survivability rate by cause.
    *
    */
   public void readSurvivabilityByCause (int numberOfLines) {
       // WRITE YOUR CODE HERE
       int cause=0;
       int yearCause=0;
       double rateTemp=0.0;
 
       survivabilityByCause=new SurvivabilityByCause();
 
       for (int i=0;i<numberOfLines;i++){
           cause=StdIn.readInt();
           yearCause=StdIn.readInt();
           rateTemp=StdIn.readDouble();
           survivabilityByCause.addData(cause,yearCause,rateTemp);
 
 
       }
 
   }
 
 
  
   /*
    * Returns a Patient array containing the patients,
    * from the patients array, that have age above the parameter age.
    *
    * The return array has to be completely full with no empty
    * spots, that is the array size should be equal to the number
    * of Patients with age above the parameter age.
    *
    * Return null if there is no Patient with age above the
    * parameter age.
    */
   public Patient[] getPatientsWithAgeAbove(int age) {
       // WRITE YOUR CODE HERE
 
      
       int count = 0;
      int tempCount=0;
  
       for(int j=0;j<patients.length; j++){
          
           if (patients[j].getAge()>=age){
               count+=1;
           }
       }
 
       if(count==0){
           return null;
       }
              
       Patient[]patientAges=new Patient[count];
              
       for(int k=0;k<patients.length;k++){
            if (patients[k].getAge()>=age){
               patientAges[tempCount]=patients[k];
                tempCount++;
           }           
 
       }
           
           return patientAges;
   } 
 
 
 
 
   /*
    * Returns a Patient array containing the patients, from the patients array,
    * that have the heart condition cause equal to the parameter cause.
    *
    * The return array has to be completely full with no empty
    * spots, that is the array size should be equal to the number
    * of Patients with the heart condition cause equal to the parameter cause.
    *
    * Return null if there is no Patient with the heart condition cause
    * equal to the parameter cause.
    */
   public Patient[] getPatientsByHeartConditionCause(int cause) {
 
       // WRITE YOUR CODE HERE
 
       int count=0;
       int tempCount=0;
 
       for (int i=0; i<patients.length; i++){
           if (patients[i].getCause()==cause){
               count+=1;
           
           }
       }
 
       if (count==0){
           return null;
       }
 
       Patient[]conditionCause=new Patient[count];
 
       for(int k=0;k<patients.length;k++){
           if (patients[k].getCause()==cause){
              conditionCause[tempCount]=patients[k];
               tempCount++;
          }           
 
      }
 
      return conditionCause;
 
     
   }
 
   /*
    * Returns a Patient array containing patients, from the patients array,
    * that have the state of health equal to the parameter state.
    *
    * The return array has to be completely full with no empty
    * spots, that is the array size should be equal to the number
    * of Patients with the state of health equal to the parameter state.
    *
    * Return null if there is no Patient with the state of health
    * equal to the parameter state.
    */
   public Patient[] getPatientsByUrgency(int urgency) {
 
       // WRITE YOUR CODE HERE
 
       int count=0;
       int tempCount=0;
 
       for (int i=0; i<patients.length; i++){
           if (patients[i].getStateOfHealth()==urgency){
               count+=1;
           
           }
       }
 
       if(count==0){
           return null;
       }
 
       Patient[] sameStateOfHealth=new Patient[count];
 
       for(int k=0;k<patients.length;k++){
           if (patients[k].getStateOfHealth()==urgency){
              sameStateOfHealth[tempCount]=patients[k];
               tempCount++;
          }           
 
      }
 
      return sameStateOfHealth;
  
   }
 
   /*
    * Assume there is a heart available for transplantation surgery.
    * Also assume that the heart is of the same blood type as the
    * Patients on the patients array.
    * This method finds the Patient to be the recepient of this
    * heart.
    *
    * The method returns a Patient from the patients array with
    * he highest potential for survivability after the transplant.
    *
    * Assume the patient returned by this method will receive a heart,
    * therefore the Patient will no longer need a heart.
    *
    * There is no correct solution, you may come up with any
    * function to find the patient with the highest potential
    * for survivability after the transplant.
    */
   public Patient getPatientForTransplant () {
 
   // WRITE YOUR CODE HERE
 
   int age1;
   int cause1;
   double num1;
   double num2;
   double avgSurvivalRate;
   double temp=0;
   int survivorPatient=0;
 
   for (int i=0; i<patients.length; i++){
       age1=patients[i].getAge();
       num1=survivabilityByAge.getRate(age1,5);
       cause1=patients[i].getCause();
       num2=survivabilityByCause.getRate(cause1,5);
 
       avgSurvivalRate=(num1+num2)/2;
       if ((patients[i].getNeedHeart()==true)&& avgSurvivalRate>temp){
           temp=avgSurvivalRate;
           survivorPatient=i;
 
       }
  
   }
   patients[survivorPatient].setNeedHeart(false);
   return patients[survivorPatient];
   }
 
}

