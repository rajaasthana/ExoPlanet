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

  ## Sample Output
    
    Orphan Planet Count: 2

    Hottest Planet in the Universe: V391 Peg b

    Discovery Timeline
    Year	Small	Medium	Large
    N/A	9	1	
    1992	4	
    1994	1	
    1930	1	
    1995	1	
    1996	6	
    1997	1	
    1998	5	
    1999	10	1	
    2000	20	
    2001	13	
    2002	29	1	
    2003	25	
    2004	24	5	
    2005	31	3	
    2006	24	6	
    2007	48	16	
    2008	44	21	1	
    2009	75	6	
    2010	81	39	
    2011	140	48	1	
    2012	106	21	
    2013	107	30	2	
    2014	897	30	
    2015	162	30	
    2016	1272	26	
    1781	1	
    1846	1	

