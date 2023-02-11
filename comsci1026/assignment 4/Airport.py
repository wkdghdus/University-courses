class Airport:

    def __init__(self, code, city, country):
        """
        Constructor function to initialize the instance variables _code, _city, and _country 

        :param str code: airport code
        :param str city: airport city
        :param str country: airport country
        """

        #initialize with corresponding parameter
        self._code = code
        self._city = city
        self._country = country
    
    def __repr__(self):
        """
        :returns: representation of airport in following format: code (city, country)
        """

        #create returning string value 
        rtrn = "%s (%s, %s)" % (self._code, self._city, self._country)

        return rtrn

    
    def getCode(self):
        """
        Function to get _code value
        """

        return self._code

    def getCity(self):
        """
        Function to get _city value
        """

        return self._city

    def getCountry(self):
        """
        Function to get _country value
        """

        return self._country
    
    def setCity(self, city):
        """
        function to set (update) _city value

        :param str city: new city value
        """

        self._city = city

    def setCountry(self, country):
        """
        Function to set (update) _country value

        :param str country: new country value
        """

        self._country = country