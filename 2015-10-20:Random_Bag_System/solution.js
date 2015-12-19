

var peices = 'OISZLJT'.split('');
var bag = [];
var answer = [];

times = 50;


while(times-- > 0){
    if(bag.length == 0) bag = peices.slice();
    var index = Math.floor((Math.random()*bag.length))%bag.length;
    process.stdout.write(bag[index]);
    bag.splice(index, 1);
}
process.stdout.write('\n');

