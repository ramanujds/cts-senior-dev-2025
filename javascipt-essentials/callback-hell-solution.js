function fetchData(){
   return new Promise((resolve) => {
         console.log('Data fetched..');
         resolve();
    });
}

function processData(){
    return new Promise((resolve) => {
            console.log('Data Processed..');
            resolve();
     });
}

function displayData(){
    console.log('Displayed Data')
}

fetchData()
   .then(processData)
   .then(displayData)
   .then(() => console.log('All operations completed!'));
   