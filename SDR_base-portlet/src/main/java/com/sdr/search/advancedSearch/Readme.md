I. Search Rule
		
	1. Basic(equal)   key: value    
	2. Like           key: keywo*  (O) 
		              key: k*yword (O)
		              key: *eyword (X)
	3. Range          key: [value TO value]
		
	4. And            key: value  +  key: value
		              key: value AND key: value 
		    
	5. Or             key: value     key: value (space)
		              key: value OR key: value 
		    
	6. Not            key: value  -  key: value
		  
II. Example
	1. current result
		a. numeric range test : bandgap: [4.9 TO 11.1]
		b. bandgap:3.1451 -> bandgap:3.1451
		c. bandgap:"3.1451" -> bandgap:3.1451 //default exact search 
		d. material: co2* 
		e. (bandgap: [4.9 TO 11.1]  AND material: co2*) - sutja: 300
		f. ((bandgap: [4.9 TO 11.1]  AND material: co2*)  - sutja: 700)  ((bandgap: [4.9 TO 11.1]  AND material: co2*) - sutja: 300)
		 
	2. exception result
		a. material: ca(co2)2 -> material:ca co2 2 // wrong result
		b. material: "ca(co2)2" -> material:"ca co2 2" // wrong result
					material: ca(co2)2 then material: ca*co2*2
		c. material: *co2* -> no search !! 
		d. finalenergy: -92.03665177 // no search !!
		e. finalenergy: "-92.03665177" -> finalenergy: "92.03665177" //no search !!
		   finalenergy: *92.03665177 // not parse 'finalenergy: *92.03665177': '*' or '?' not allowed as first character in WildcardQuery