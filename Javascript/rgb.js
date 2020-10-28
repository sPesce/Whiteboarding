function rgb(r, g, b){
  return[r,g,b].reduce((acc,val) => {
    let str = constrainRange(val).toString(16).toUpperCase();
    const extra = 2 - str.length;
    return acc + "0".repeat(extra) + str;
  },"");
}

const constrainRange = num => Math.min(255, Math.max(0,num));