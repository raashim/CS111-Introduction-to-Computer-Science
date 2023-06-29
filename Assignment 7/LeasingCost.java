public class LeasingCost {
    
    /* 
     * Description:
     *      This method creates an array of Vehicles objects from the given file name
     *      ******IMPORTANT******
     *      This method calls buildVehicle.
     () method, which is STUDENT'S task to complete.
     *
     * Parameters:
     *      filename: the file name containing the vehicles description
     *
     * File format:
     *      the first line of the file containing an integer representing how many vehicles will be described 
     *      in the following lines.
     *      Each line other than the first line describes one vehicle; 
     *      7 or 8 fragments of data in randomly placed order describing the vehicle (7 for gas car, 8 for electric car) in each line. 
     *      Each fragment end with the ';' character
     * 
     *   All possible fragments:
     *      type:FULETYPE;
     *          FULETPE can be gas or electric
     *      name:CARNAME;
     *          CARNAME is the name of the car
     *      due:DUEATSIGNING;
     *          DUEATSIGNING is a double number describing the dollar amount due when signing the lease
     *      length:LEASELENGTH;
     *          LEASELENGTH is an integer number describing the lease length in months
     *      monthly:MONTHLYCOST;
     *          MONTHLYCOST is a double number describing the monthly lease cost in dollar
     *      mile/unit:USAGE; 
     *          USAGE is a double describing miles the car can drive per gallon if fuel type is GAS, or miles the car can drive per kWh if fuel type is ELECTRIC
     *      allowance:MILEAGEALLOWANCE;
     *          MILEAGEALLOWANCE is an integer describing the maximum distance the car is allowed to travel per month
     *      charger:CHARGERCOST;
     *          CHARGERCOST is a double describing the cost of charger for electric cars, this fragment can only appear if the line is describing an electrical car
     *   Example of a line:
     *      type:gas; name:civic; due:1000; length:3; monthly:295; mile/unit:34; 
     *
     * Returns:
     *      this method returns an array of Vehicle objects 
     */
	public static Vehicle[] createAllVehicles(String filename) {
        StdIn.setFile(filename);

        int numberOfCars = Integer.parseInt( StdIn.readLine() );
        Vehicle[] vehicles = new Vehicle[numberOfCars];

        for ( int i = 0; i < numberOfCars; i++ ) {
        	String line = StdIn.readLine();
            vehicles[i] = createVehicle(line);
        }
        return vehicles;
    }

    /* 
     * Description:
     *      This method calculates the CO2 emission given several parameters
     * Parameters:
     *      numberOfMonth: 
     *          the lease length in months
     *      usage: 
     *          miles the car can drive per gallon if fuelType is GAS, or
     *			miles the car can drive per kWh    if fuelType is ELECTRIC
     *      mileageAllowance: 
     *			mileage allowance per month
     *		co2PerUnit:
     *			kg of CO2 released with the combustion of each gallon of gasoline, or
     *			kg of CO2 are emitted to generate 1 kWh on average
     * Returns:
     *      this method returns a double representing the CO2 emission produced by the car during the lease.
     */
	public static double computeCO2(double numberOfMonth, double usage, double mileageAllowance, double co2PerUnit ){
		double miles = numberOfMonth * mileageAllowance ;
		return miles/usage*co2PerUnit;
    }

    /* 
     * Description:
     *      This method calculates the cost the fuel during the lease given several parameters
     * Parameters:
     *      numberOfMonth: 
     *          the lease length in months
     *      usage: 
     *          miles the car can drive per gallon if fuelType is GAS, or
     *			miles the car can drive per kWh    if fuelType is ELECTRIC
     *      mileageAllowance: 
     *			mileage allowance per month
     *		fuelPrice: 
     *			price of 1 kWh in cents of a dollar,  if fuelType is GAS, or
     *			price of one gallon of gas in dollars if fuelType is ELECTRIC
     * Returns:
     *      this method returns a double representing the fuel cost during the lease
     */
	public static double computeFuelCost(double numberOfMonth, double usage, double mileageAllowance, double fuelPrice){
    	double miles = numberOfMonth * mileageAllowance;
        double cost = miles/usage * fuelPrice;
    	return cost;
    }

    /* 
     * Description:
     *      This method calculates the cost of lease
     * Parameters:
     *      dueAtSigning: 
     *          the dollar amount due at signing the lease
     *      numberOfMonths: 
     *          lease length in months
     *      monthlyCost: 
     *			cost of the lease per month
     * Returns:
     *      this method returns a double representing the lease cost during the entire lease
     */
	public static double computeLeaseCost(double dueAtSigning, int numberOfMonths, double monthlyCost){
    	
        return dueAtSigning + numberOfMonths*monthlyCost;
    }

    /* 
     * Description:
     *      This method creates and returns an Vehicle object with name, Lease, and Fuel properly populated based on the given string
     *      
     * Parameters:
     *      one string containing 7~8 fragments descrbing the 
     *   All possible fragments:
     *      type:FULETYPE;
     *          FULETPE can be gas or electric
     *      name:CARNAME;
     *          CARNAME is the name of the car
     *      due:DUEATSIGNING;
     *          DUEATSIGNING is a double number describing the dollar amount due when signing the lease
     *      length:LEASELENGTH;
     *          LEASELENGTH is an integer number describing the lease length in months
     *      monthly:MONTHLYCOST;
     *          MONTHLYCOST is a double number describing the monthly lease cost in dollar
     *      mile/unit:USAGE; 
     *          USAGE is a double describing miles the car can drive per gallon if fuel type is GAS, or miles the car can drive per kWh if fuel type is ELECTRIC
     *      allowance:MILEAGEALLOWANCE;
     *          MILEAGEALLOWANCE is an integer describing the maximum distance the car is allowed to travel per month
     *      charger:CHARGERCOST;
     *          CHARGERCOST is a double describing the cost of charger for electric cars, this fragment can only appear if the line is describing an electrical car
     *   Example of a line:
     *          type:gas.name:civic.due:1000.length:3.monthly:295.mile/unit:34.mileageAllowance:1200.
     *          monthly:238.name:Bolt.due:1000.mileageAllowance:20000.length:15.mile/unit:50.type:electric.charger:500.
     * Returns:
     *      this method creates and returns an Vehicle object with name, Lease, and Fuel properly populated
     *
     * Hint: 
     *      to extract the information of each fragments, we can use 
     *          s.substring(int startIndex, int endIndex) 
     *          s.indexOf(String target)
     *          s.indexOf(char target)
     *
     *      for example, assume we have: 
     *          String s = "description1:ABCD;  description2:EFGH;  description3:IJKL;"
     *      if we want to find the data for description 2, we can first take the substring of the entire string from the letter 'E'
     *      but first we need to find the index of 'E', we can do it by find the index of the string "description2:" and add 13("description2" is 13 chars long)to it
     *      and then we can take the substring from 'E' until the end of the entire string
     *      now use s.substring to exract:
     *          "EFGH;  description3:IJKL;" and let's call it newString for now. 
     *      to extract "EFGH" (the data we want) from newString. we need to find the index of the first ';' which we can simply use newString.indexOf(';')
     *      then we can take the substring of the newString knowing the index of ;
     *      we now have extracted "EFGH" from the String s
     *      the last step is just to convert the datatype based on what type of data we are extracting
     */
	public static Vehicle createVehicle(String description){
        
        // COMPLETE THIS METHOD
        int nameIndex = description.indexOf("name:") + 5; 
        String tempName = description.substring(nameIndex); 
        int nameEnd = tempName.indexOf(";"); 
        String name = tempName.substring(0, nameEnd); 

        int typeIndex = description.indexOf("type:") + 5; 
        String tempType = description.substring(typeIndex); 
        int tempEnd = tempType.indexOf(";"); 
        String type = tempType.substring(0, tempEnd);

        int dueIndex = description.indexOf("due:") + 4; 
        String tempDue = description.substring(dueIndex); 
        int dueEnd = tempDue.indexOf(";"); 
        String dueString = tempDue.substring(0, dueEnd); 
        double due = Double.parseDouble(dueString); 

        int monthIndex = description.indexOf("monthly:") + 8; 
        String monthlyTemp = description.substring(monthIndex); 
        int monthEnd = monthlyTemp.indexOf(";"); 
        String monthlyString = monthlyTemp.substring(0, monthEnd); 
        double monthly = Double.parseDouble(monthlyString); 

        int lengthIndex = description.indexOf("length:") + 7; 
        String lengthTemp = description.substring(lengthIndex); 
        int lengthEnd = lengthTemp.indexOf(";"); 
        String lengthString = lengthTemp.substring(0, lengthEnd); 
        int length = Integer.parseInt(lengthString); 
        
        int mileUnitIndex = description.indexOf("mile/unit:") + 10; 
        String mileUnitTemp = description.substring(mileUnitIndex); 
        int mileUnitEnd = mileUnitTemp.indexOf(";"); 
        String mileUnitString = mileUnitTemp.substring(0, mileUnitEnd); 
        double mileUnit = Double.parseDouble(mileUnitString); 

        int allowanceIndex = description.indexOf("allowance:") + 10; 
        String allowanceTemp = description.substring(allowanceIndex); 
        int allowanceEnd = allowanceTemp.indexOf(";"); 
        String allowanceString = allowanceTemp.substring(0, allowanceEnd); 
        int allowance = Integer.parseInt(allowanceString); 

        Fuel FuelObject;
        if(type.equals("electric")) {
            int chargerIndex = description.indexOf("charger:") + 8; 
            String chargerTemp = description.substring(chargerIndex); 
            int chargerEnd = chargerTemp.indexOf(";"); 
            String chargerString = chargerTemp.substring(0, chargerEnd); 
            int charger = Integer.parseInt(chargerString); 

            FuelObject = new Fuel (mileUnit, charger); 
        }
        else {
            FuelObject = new Fuel (mileUnit);

        }


        Lease LeaseObject = new Lease (due, length, monthly, allowance ); 

        Vehicle VehicleObject = new Vehicle (name, FuelObject, LeaseObject); 

	    return VehicleObject;
	}

    /* 
     * Description:
     *      The method calculates and assign CO2Emission, FuelCost, leastCost, of each vehicle.
     *      
     * Parameters:
     *      vehicles: 
     *          an array of Vehicle objects, initilized by getVehicles() method
     *      gasPrice: 
     *          a double representing the price of gas in dollar/gallon
     *      electricityPrice: 
     *			a double representing the price of gas in dollar/kWh
     * Hint:
     *      **********REMEMBER charger cost for electric cars***************
     *      feel free to use:
     *          computeCO2(double numberOfMonth, double usage, double mileageAllowance, double co2PerUnit )
     *          computeFuelCost(double numberOfMonth, double usage, double mileageAllowance, double fuelPrice)
     *          computeLeaseCost(double dueAtSigning, int numberOfMonths, double monthlyCost)
     */
	public static void computeCO2EmissionsAndCost( Vehicle[] vehicles, double gasPrice, double electricityPrice ){
	   
        // COMPLETE THIS METHOD

        for(int i = 0; i < vehicles.length; i++) {
           /* vehicles[i].getLease().getLeaseLength(); //numberOfMonths
            vehicles[i].getFuel().getUsage(); //gets usage 
            vehicles[i].getLease().getMileageAllowance(); //gets mileage allowance 
            vehicles[i].getLease().getDueAtSigning(); //gets dueAtSigning 
            vehicles[i].getLease().getMonthlyCost(); //gets monthly cost */
            
            if (vehicles[i].getFuel().getType() == 2) { //electric car
                double CO2UnitElectric = 0.453;
                
                computeCO2(vehicles[i].getLease().getLeaseLength(), vehicles[i].getFuel().getUsage(), 
                vehicles[i].getLease().getMileageAllowance(), CO2UnitElectric); 

                computeFuelCost(vehicles[i].getLease().getLeaseLength(), vehicles[i].getFuel().getUsage(),
                vehicles[i].getLease().getMileageAllowance(), electricityPrice); 

                double fuelCost = computeFuelCost(vehicles[i].getLease().getLeaseLength(), vehicles[i].getFuel().getUsage(),
                vehicles[i].getLease().getMileageAllowance(), electricityPrice); 

                computeLeaseCost(vehicles[i].getLease().getDueAtSigning(), vehicles[i].getLease().getLeaseLength(), 
                vehicles[i].getLease().getMonthlyCost());

                vehicles[i].setFuelCost(fuelCost);

                double leaseCost = computeLeaseCost(vehicles[i].getLease().getDueAtSigning(), vehicles[i].getLease().getLeaseLength(), 
                vehicles[i].getLease().getMonthlyCost()); 
               
                double totalCost = leaseCost + fuelCost + vehicles[i].getFuel().getCharger(); 
                vehicles[i].setTotalCost(totalCost);

                vehicles[i].setCO2Emission(computeCO2(vehicles[i].getLease().getLeaseLength(), vehicles[i].getFuel().getUsage(), 
                vehicles[i].getLease().getMileageAllowance(), CO2UnitElectric)); 

            } 
            else { 
                double CO2UnitGas = 8.887; 

                computeCO2(vehicles[i].getLease().getLeaseLength(), vehicles[i].getFuel().getUsage(), 
                vehicles[i].getLease().getMileageAllowance(), CO2UnitGas); 

                double fuelCost = computeFuelCost(vehicles[i].getLease().getLeaseLength(), vehicles[i].getFuel().getUsage(),
                vehicles[i].getLease().getMileageAllowance(), gasPrice); 

                double leaseCost = computeLeaseCost(vehicles[i].getLease().getDueAtSigning(), vehicles[i].getLease().getLeaseLength(), 
                vehicles[i].getLease().getMonthlyCost());

                vehicles[i].setFuelCost(fuelCost);

                double totalCost = leaseCost + fuelCost; 
                vehicles[i].setTotalCost(totalCost);

                vehicles[i].setCO2Emission(computeCO2(vehicles[i].getLease().getLeaseLength(), vehicles[i].getFuel().getUsage(), 
                vehicles[i].getLease().getMileageAllowance(), CO2UnitGas)); 
            }

    



        }

    	}


    /**
     * How to compile:
     *     javac LeasingCost.java
     * How to run:         
     *     java LeasingCost vehicles.txt 3.85 11.0
     **/
	public static void main (String[] args) {
        String filename         = args[0];
        double gasPrice 		= Double.parseDouble( args[1] );
		double electricityPrice = Double.parseDouble( args[2] );

		Vehicle[] vehicles = createAllVehicles(filename); 
		computeCO2EmissionsAndCost(vehicles, gasPrice, electricityPrice);

		for ( Vehicle v : vehicles ) 
            System.out.println(v.toString());
    }
}
