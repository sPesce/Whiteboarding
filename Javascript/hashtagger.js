function generateHashtag (str) {  
  //num of letters/digits/non whitespace
  const charCount = ((str || '').match(/\S/g) || []).length;
  
  const reducer = (acc,val) => acc + val[0].toUpperCase() + val.slice(1).toLowerCase();
  //false if there are 0 or more than 140 non-ws chars, else capitalCase reduce
  return (!charCount || charCount >= 140) ? false : str.split(/\s+/).reduce(reducer,'#');        
}
