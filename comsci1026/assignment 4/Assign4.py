from Flight import *
from Airport import *

allAirports = []
allFlights = {}

def findAirport(airportLst, airportCode):
    """
    finds the airport with corresponding airport code
    then returns the Airport object of the airport

    :param List airportLst: list of airport object
    :param str airportCode: airport code
    """

    for airport in airportLst:
        if airportCode == airport.getCode():
            return airport

def stripWhiteSpace(list):
    """
    strips any white space or new line character for the elements of a list

    :param List list: list of elements to be stripped
    :returns: A new list with stripped character
    """
    for index in range(len(list)):
        list[index] = list[index].strip(" \t\n")   # eliminating possible white space and \n
    
    return list


def loadData(airportFile, flightFile):
    """
    Function that loads two files with information of airport and flights
    Save airports as a list to allAirport variable. Save flights as a dictionary to allFlights varaiable
    Returns true if the data is loaded and saved properly, else returns false
    

    :param File airportFile: txt file of airport information
    :param File flightFile: txt file of flight information
    :returns: boolean value
    """

    try:

        aFile = open(airportFile, "r", encoding= "utf8")    #airport file
        fFile = open(flightFile, "r", encoding="utf8")      #flight file

        ###airport file to list
        for line in aFile:
            lst = line.split(",")   #create a list of individual airport information

            lst = stripWhiteSpace(lst)
            
            airport = Airport(lst[0], lst[2], lst[1])   #creating airport object

            allAirports.append(airport)

        ###flight file to dictionary
        for line in fFile:
            lst = line.split(",")   #create a list of individual element

            lst = stripWhiteSpace(lst)

            flight = Flight(lst[0], findAirport(allAirports, lst[1]), findAirport(allAirports,lst[2]))

            originCode = (flight.getOrigin()).getCode()     #airport code of the origin airport

            #if the originCode already exists 
            if originCode in allFlights:
                (allFlights[originCode]).append(flight)     #append the flight object to the "list of all Flight objects in which the Flight's origin is the same"
            #if originCode does not exist in dictionary
            else:
                allFlights[originCode] = [flight]           #create a new list

        aFile.close()
        fFile.close()

        return True

    except:
         return False



def getAirportByCode(code):
    """
    Return the Airport object that has the given code
    If there is no Airport found for the given code, returns -1.

    :param str code: airport code
    :return: corresponding airport or -1
    """

    #loop through allAirports list and find the airport with given code
    for airport in allAirports:
        if airport.getCode() == code:
            return airport
    
    #return -1 if such an airport does not exist
    return -1

def findRelatedFlights(airportList):
    """
    Return a list that contains all Flight objects that involve the given airports either as the origin or the destination

    :param List airportList: list of an airport
    :return: a list of related flight with the city
    """
    relatedFlights = []

    #create an object of the flights that is related to the airport in the list
    for flightList in allFlights.values():   #iterate through the distionary of flight list
        for flight in flightList:           #iterate through the flight list, and find select individual flight
            if (flight.getDestination() in airportList or flight.getOrigin() in airportList):
                relatedFlights.append(flight)
    
    return relatedFlights

def findAllCityFlights(city):
    """
    Return a list that contains all Flight objects that involve the given city either as
    the origin or the destination

    :param str city: a city with an airport
    :return: a list of related flight with the city
    """

    airportList = [] 

    #Create a list of airports in the given city
    for airport in allAirports: 
        if airport.getCity() == city:
            airportList.append(airport)     

    flightList = findRelatedFlights(airportList)
    
    return flightList

def findAllCountryFlights(country):
    """
    Return a list that contains all Flight objects that involve the given country either as the origin or the destination (or both)
    
    :param str country: a country with an airport
    :return: a list of ralted flight with the country
    """
    airportList = [] 

    #Create a list of airports in the given city
    for airport in allAirports: 
        if airport.getCountry() == country:
            airportList.append(airport)     

    flightList = findRelatedFlights(airportList)
    
    return flightList

def getDestinationList(flightList):
    """
    give the list of destination airports when given a list of flights

    :param List flightList: list of flights
    :return: list of destinations
    """

    destList = []

    #loop through the flight and append destination
    for flight in flightList:
        destList.append(flight.getDestination())
    
    
    return destList

def findFlightBetween(origAirport, destAirport):
    """
    Find if there are any direct or single-hop connecting flight from a airport to another

    :param Airport origAirport: origin airport
    :param Airport destAirport: destination airport
    :return: direct flight -> single-hop flight -> -1 if none
    """

    flightList = allFlights[origAirport.getCode()]  # list of flights with given origin airport
    destList = getDestinationList(flightList)       # list of the destinations

    #if there is a direct plane
    if destAirport in destList:

        return ("Direct flight: " + origAirport.getCode() + " to " + destAirport.getCode())
    
    else: #if there are no direct plane

        oneHopAirports = set()              #a set of second airport of possible one hop travel 

        #loop through the airports which is the destination of the given origin airport (secondAirport)
        for secondAirport in destList:
            
            #declare variables
            secondAirportCode = secondAirport.getCode()     #code of the second airport
            flightList = allFlights[secondAirportCode]      #flight list with the origin of given origin's destination
            secondDestList = getDestinationList(flightList) #the destinations of the second airport

            #if the second airport has a flight which goes to the given destination airport
            if destAirport in secondDestList:
                oneHopAirports.add(secondAirportCode)   #add the second airport's code into the set
    
        #check if there are any one hop flights and return corresponding value
        if len(oneHopAirports) == 0:    #no one hop flights
            return -1
        else:                           #there are one hop flights
            return oneHopAirports       
    

def findReturnFlight(firstFlight):
    originAirportCode = (firstFlight.getOrigin()).getCode()
    destAirportCode = (firstFlight.getDestination()).getCode()

    #loop through the flights with the destination with 
    for flight in allFlights[destAirportCode]:
        
        #if there are a flight that goes back to the origin
        if originAirportCode == (flight.getDestination()).getCode():
            return flight

    return -1 

print (loadData("airports.txt", "flights.txt"))