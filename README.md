# ExoPlanet

This application parses the exoplanet data and displays the following information:
  1. The number of orphan planets (no star).
  2. The name (planet identifier) of the planet orbiting the hottest star.
  3. A timeline of the number of planets discovered per year grouped by size. Use the following groups: “small” is less than 1 Jupiter radii, “medium” is less than 2 Jupiter radii, and anything bigger is considered “large”. For example, in 2004 we discovered 2 small planets, 5 medium planets, and 0 large planets.
  
  ## Prerequisite to Run the application
  1. JDK 1.8
  2. Maven 3
  3. Preferred IDE: Eclipse
  
  ## Steps to Run
  1. Download/Clone the source code from github repository
  2. Import the Maven project in Eclipse
  3. Run the below maven command to download dependencies.<br/>
      a. mvn install
  4. Once the maven build is successful, run the application with the below command <br/>
      a. Right-click on Application.java -> Run As -> Java Application
  
