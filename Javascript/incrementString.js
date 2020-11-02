function incrementString (strng) {
  const [inpStr,numberStr,] = strng.split(/(\d+$)/);
  if(numberStr === undefined)
    return inpStr + "1";

  const count = parseInt( numberStr ) + 1;

  if(!numberStr.startsWith('0')) 
    return inpStr + count;

  const [,zeroesStr,num] = numberStr.split(/(^0+)/);
  let zeroCount = zeroesStr.length;
  if(!num || count % 10 === 0)
    zeroCount--; 
  
  return inpStr + '0'.repeat(zeroCount) + count;
}
