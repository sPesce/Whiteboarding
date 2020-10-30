function humanReadable(seconds) {
  const hours = Math.floor(seconds / 3600);
  seconds -= hours * 3600;
  
  const minutes = Math.floor(seconds/60);
  seconds -= minutes * 60;
  
  return [hours,minutes,seconds].map(num => format(num))
  .join(":");
}

const format = num => {
  if(num < 10)
    return '0' + num;
  return num
}