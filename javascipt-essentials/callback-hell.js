function fetchData(callback){
    console.log('Data fetched..');
    callback();  
}

function processData(callback){
    console.log('Data Processed..');
    callback();
}

function displayData(){
    console.log('Displayed Data')
}

fetchData(()=>processData(()=>displayData()));