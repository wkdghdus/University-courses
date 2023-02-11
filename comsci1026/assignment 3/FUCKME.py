# univRanking.py
# Date: November 16th, 2022
# Author: Hoyeon Luke Jang
# description: A program with a collection of function that reads given csv data and writes specific information in output.txt file

##CONTANTS
UNIV_RANKING = "Desktop/comsci1026/assignment 3/TopUni.csv"
CAPITALS_FILE = "Desktop/comsci1026/assignment 3/capitals.csv"
OUTPUT_FILE = "output.txt"


#----------------------------------------

##FUNCTIONS

#Name: csvToList
#Param: csv file
#Descrip: Converting datas in csv file to a list
def csvToList(csvFile):
    ##opening given file
    f = open(csvFile, "r", encoding='utf8')
    ##creating a list to appened the line
    lst = []

    ##For loop to append information to the full list as an individual list
    #reading each lines of the file
    for line in f:
        #if the line does not contain anything break the loop
        if (line == ""):
            break
        
        #get rid of new line character
        line = line.rstrip()

        #Append the line of information as a list to the full list
        lst.append(line.split(","))
    

    #close file
    f.close()
    
    return lst


#Name: WriteOnOutputFile
#param: a string value
#writes the given string value on the output.txt file with two new line character
def writeOnOutputFile(stringValue):
    #open output file
    f = open(OUTPUT_FILE, "a", encoding='utf8')
    
    #writing the given value with two new lines as shown in the example
    f.write(stringValue + "\n\n")
    
    #closing file
    f.close()


#Name: findIndex
#param: String of the category name, and the list
#description: finds the index of the category
def findIndex(category, list):
    index = list[0].index(category)

    return index


##### PART 1
#Name: uniCounts
#Param: university ranking file
#description:  show the total number of the universities in the TopUni.csv file
def uniCounts(topUniFile):
    
    #convert uni ranking file to a list
    lst = csvToList(topUniFile)

    #length - 1 of the list is equal to the number of university
    #index 0 shows the category 
    uniNum = len(lst) - 1

    #creating output
    output = "Total number of universities => %s" % (uniNum)

    #writing the output in the output.txt file
    writeOnOutputFile(output)



##### PART 2
#Name: availableCountries
#Param: University ranking file
#Description: show the list of all country names available in the TopUni.csv in order with no repetition
def availableCountries(topUniFile):

    #an empty string that'll contain all the countries
    countries = ""

    #convert the TopUniv.csv file into list
    infos = csvToList(topUniFile)

    #find the index of the countries in the file
    index = findIndex("Country", infos)

    #remove the first index, which includes the categories
    infos.pop(0)

    #going through each line
    for line in infos:

        #finding the country of the university
        country = line[index].upper()

        #add if the country is not in the list of countries
        if country not in countries.split(", "):
            countries += country + ", "

    #getting rid of a space at the end
    countries = countries.rstrip(", ")

    #creating formatted output
    output = "Available countries => " + countries

    #write onto the output.txt
    writeOnOutputFile(output)
    

##### PART 3
#Name: available continents
#Param: capital 
#Description: show the list of all continent names available in the capitals.csv file in order with no repetition.
def availableContinents(capitalsFile):

    #an empty string that'll contain all the continents
    continents = ""

    #convert the capital.csv file into list
    infos = csvToList(capitalsFile)

    #find the index of the continent in the file
    index = findIndex("Continent", infos)

    #remove the first index, which includes the categories
    infos.pop(0)

    #going through each line
    for countries in infos:

        #finding the capital of the countries
        continent = countries[index].upper()

        #add if the country is not in the list of countries
        if continent not in continents.split(", "):
            continents += continent + ", "

    #getting rid of a space at the end
    continents = continents.rstrip(", ")

    #creating formatted output
    output = "Available continents => " + continents

    #write onto the output.txt
    writeOnOutputFile(output)


##### PART 4
#Name: highestRankUni
#Param: a university rank file and selected country
#Description: show the highest ranking university of the given country with its international ranking
def highestRankUni(selectedCountry, topUniFile):
    
    #convert topUni.csv to list
    infos = csvToList(topUniFile)

    #find index of the country category
    countryIndex = findIndex("Country", infos)
    #find index of the rank category
    rankIndex = findIndex("World Rank", infos)
    #find index of the university
    uniIndex = findIndex("Institution name", infos)

    #find the first university that is in the country
    for info in infos:
        #if the country is found
        if info[countryIndex].upper() == selectedCountry.upper():
            #save the rank and university
            rank = int(info[rankIndex])
            university = info[uniIndex].upper()
            break

    
    #create output
    output = "At international rank => %d the university name is => %s" % (rank, university)

    #write output on the output.txt file using method
    writeOnOutputFile(output)

##### PART 5
#Name: highestNationalRankUni
#Param: a university rank file and selected country
#Description: show the highest ranking university of the given country with its national ranking
def highestNationalRankUni(selectedCountry, topUniFile):
    
    #convert topUni.csv to list
    infos = csvToList(topUniFile)

    #find index of the country category
    countryIndex = findIndex("Country", infos)
    #find index of the rank category
    rankIndex = findIndex("National Rank", infos)
    #find index of the university
    uniIndex = findIndex("Institution name", infos)

    #find the first university that is in the country
    for info in infos:
        #if the country is found
        if info[countryIndex].upper() == selectedCountry.upper():
            #save the rank and university
            rank = int(info[rankIndex])
            university = info[uniIndex].upper()
            break

    
    #create output
    output = "At national rank => %d the university name is => %s" % (rank, university)

    #write output on the output.txt file using method
    writeOnOutputFile(output)


##### PART 6
#Name: avgUniScore
#Param: selected country and topUni.csv file
#description: calculating average score of the university of the selected country
def avgUniScore(selectedCountry, topUniFile):

    #number of universities
    uniNum = 0
    #total score
    ttlScore = 0

    #convert file to list
    infos = csvToList(topUniFile)
    
    #find index of the score
    scoreIndex = findIndex("Score", infos)
    #find index of country
    countryIndex = findIndex("Country", infos)

    #loop through the ranking informations
    for info in infos:
        #if the country is found
        if info[countryIndex].upper() == selectedCountry.upper():
            #update number of university
            uniNum += 1
            #update total score
            ttlScore += float(info[scoreIndex])

    #calculate average
    avg = ttlScore / uniNum

    #create output
    output = "The average score => %.2f%%" % (avg)

    #write output on the output.txt file
    writeOnOutputFile(output)

    return avg


##### PART 7
#Name: relativeUniScore
#Param: continent name, topUni.csv, capitals.csv
#Description: finding the relative university score of the given continent
def relativeUniScore(selectedCountry, topUniFile, capitalsFile):

    #convert all the files to list
    uniInfo = csvToList(topUniFile)         #topUni.csv
    countryInfo = csvToList(capitalsFile)    #capital.csv

    ## find the continent that the country is associated in
    # find index 
    continentIndex = findIndex("Continent", countryInfo)    #continent index
    countryIndex = findIndex("Country Name", countryInfo)   #country index

    # loop through the country info and find the continent of the selected country
    for info in countryInfo:
        # if the country is found, initialize continent variable
        if info[countryIndex].upper() == selectedCountry.upper():
            continent = info[continentIndex]
            break
    

    print(continent)


    ## Create list of the countries in the given continent
    #list of countries
    countriesList = []

    #loop through the list of capital.csv file 
    for info in countryInfo:
        #if the given continent is found
        if info[continentIndex] == continent:
            #append the country to the list
            countriesList.append(info[countryIndex])
    
    print(countriesList)

    ### find the relative average of the all the countries in the selected continent
    ## find index
    countryIndex = findIndex("Country", uniInfo)    # country index
    scoreIndex = findIndex("Score", uniInfo)        # score index
    
    ##declare and initialize variables needed
    highestScore = 0        #highest score 
    ttlScore = 0            #total score
    uniNum = 0              #number of universities

    #loop through the information in topUni.csv file
    for info in uniInfo:
        #if the country is in the continent
        if info[countryIndex] in countriesList:
            #update number of universities
            uniNum += 1
            #update totalScore
            ttlScore += float(info[scoreIndex])
            #test and update the highest score
            if highestScore < float(info[scoreIndex]):
                highestScore = float(info[scoreIndex])

    print("uni num: ", uniNum)
    print("ttl score: ", ttlScore)
    print("highest score: ", highestScore)

    ##calculate relative score using given formula
    avg = (avgUniScore(selectedCountry, topUniFile))
    relScore = (avg / highestScore) * 100

    # Create output
    output = "The relative score to the top university in %s is => (%.2f / %.1f) x 100%% = %.2f%%" % (continent.upper(), round(avg,2), round(highestScore,1), round(relScore,2))

    print(output)

relativeUniScore("south korea", UNIV_RANKING, CAPITALS_FILE)

#95.0