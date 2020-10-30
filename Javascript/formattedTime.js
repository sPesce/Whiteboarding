function humanReadable(seconds, time = [], base = 3600) {
  if (time.length < 3)     
    return humanReadable( seconds % base , [...time,format(Math.floor(seconds / base))] , base/60 );     
   
  return time.join(":");//base case
}

const format = num => num < 10 ? '0' + num : num;