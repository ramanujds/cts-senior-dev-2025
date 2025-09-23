// let promise = new Promise((resolve, reject)=>{
//     let success = false;
//     if(success)
//         resolve('Operation Success')
//     else
//         reject('Operation Failed')
// })

// promise.then(result=>console.log(result))
//         .catch(message => console.error(message));

function wait(time){
    return new Promise(resolve =>{
        setTimeout(
            ()=> resolve(`Waited ${time} ms`),
            time
        )
    })
}

wait(3000).then(message => console.log(message)).catch(err => console.error(err))