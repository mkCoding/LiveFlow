A project where I learn about differences between LiveData, MutableStateFlow and SharedFlow


**Live Data**
 - Simple UI updates
 - Lifecycle aware (respects activity lifecycle)
 - Update only when screen is visible
 - Doesn't have initial value
 - Uses observe
 - only when visible
 - water bottle holds water and only released when its open (only flows when cap is open)
   

**MutableStateFlow**
- continuous data updates
- Not lifecycle Aware (doesn't respect activity lifecycle)
- Emitting even if screen isn't visible
- must have an initial value
- Uses collect
- Always ready
- River is always flowing (doesn't stop flowing)
 

**SharedFlow**
- Events, broadcast, one-time messages
- not lifecycle aware (doesn't respect activity lifecycle)
- Always ready to send
- no initial value
- uses collect
- Hot flow (always active)
- Radio: broadcast data to anyone listening
 
