async function fetchRecipe(item){

    // fetch(`https://www.themealdb.com/api/json/v1/1/search.php?s=${item}`)
    // .then(res => res.json())
    // .then(data => {
    //     console.log(data);
    //     console.log(data.meals[0].strMeal);
    // })
    // .catch(err => {
    //     console.log(`error ${err}`)
    // });

    try{
    let response = await fetch(`https://www.themealdb.com/api/json/v1/1/search.php?s=${item}`);
    let data = await response.json();
    console.log(data);
    }
    catch(err){
        console.log(`error ${err}`)
    }


}

fetchRecipe('Pizza');