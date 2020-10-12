function inArray(array1,array2){
  const solution = [];

  array1.forEach(word1 => {
    array2.forEach(word2 => {
      if(word2.includes(word1) && !solution.includes(word1))
        solution.push(word1);
    })
  });

  return solution.sort();
}