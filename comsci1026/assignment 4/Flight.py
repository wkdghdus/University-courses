from Airport import *

class Flight:

    def __init__ (self, flightNo, origin, destination):
        """
        function to initialize Flight object

        :param str flightNo: Flight number
        :param Airport origin: Origin airport
        :param Airport destination: Destination airport
        """

        #test to see if the given values are correct type
        if not (isinstance(origin, Airport) and isinstance(destination, Airport)):
            raise TypeError("The origin and destination must be Airport objects")
        
        #if the data type is correct, initialize variable
        self._flightNo = flightNo
        self._origin = origin
        self._destination = destination


    def __repr__(self): 
        """
        :returns: the representation of the flight informations
        """

        if self.isDomesticFlight():
            return "Flight: %s from %s to %s {domestic}" % (self._flightNo, self._origin.getCity(), self._destination.getCity())
        else:
            return "Flight: %s from %s to %s {international}" % (self._flightNo, self._origin.getCity(), self._destination.getCity())

    
    def __eq__(self, other):
        """
        Function that compares two flights to see if they have same origin and destination

        :param Flight other: the second flight
        :returns: boolean
        """

        try:
            #if origin and destination is equal
            if (self._origin == other.getOrigin() and self._destination == other.getDestination()):
                return True
            else:
                return False
        except: #if other variable is not a flight object
            return False

    
    def getFlightNumber(self):
        """
        :returns: _flightNo value
        """

        return self._flightNo
    
    def getOrigin(self):
        """
        :returns: _origin value
        """

        return self._origin

    def getDestination(self):
        """
        :returns: _destination value
        """

        return self._destination
    
    def isDomesticFlight(self):
        """
        Returns true if the flight is domestic, else returns false

        :returns: Boolean value
        """

        #If the origin and destination ccountry is same
        if ((self._origin).getCountry() == (self._destination).getCountry()):
            return True
        else:
            return False
    
    def setOrigin(self, origin):
        """
        Function to set (update) _origin value

        :param Airport origin: new origin value
        """

        self._origin = origin

    def setDestination(self, destination):
        """
        Function to set (update) _destination value

        :param Airport destination: new destination valuie
        """

        self._destination = destination