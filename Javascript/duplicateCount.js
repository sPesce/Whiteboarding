function duplicateCount(text){
  const count = {}
  
  return [...text].filter(char => {
    let c = char.toLowerCase();
    !count[c] && (count[c] = 0);
    count[c]++;
    return count[c] == 2;
  })
  .length;
}