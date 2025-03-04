function counter() {
    // Private variable
        let count = 0; 
      
       return function () {
         // Access and modify the private variable
            count++;
            return count;
        };
    }
    
    const increment = counter();
    console.log(increment());
    console.log(increment());
    console.log(increment());