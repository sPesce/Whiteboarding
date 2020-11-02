function incrementString (strng) {
  const [inpStr,numberStr,] = strng.split(/(\d+$)/);
  let count = !!numberStr ? parseInt(numberStr) + 1 : 1;
  let zeroCount = 0; 

  if(!!numberStr && numberStr.startsWith('0'))
  {
    const [,zeroesStr,num] = numberStr.split(/(^0+)/);
    zeroCount = zeroesStr.length - (!num || count % 10 === 0);    
  }  
  
  return inpStr + '0'.repeat(zeroCount) + count;
}

//https://www.codewars.com/kata/54a91a4883a7de5d7800009c/train/javascript