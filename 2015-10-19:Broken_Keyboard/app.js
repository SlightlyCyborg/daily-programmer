    var fs = require('fs');

    var process_input = function(data){
        //Break the data up by line
        lines = data.split('\n');
        
        var num_of_entries = parseInt(lines[0]);

        var dictionary = fs.readFileSync('/usr/share/dict/words', 'utf8');
        dictionary = dictionary.split('\n');

        for(var i=1; i<=num_of_entries; i++){
            var best_word = get_best_word(lines[i], dictionary);
            console.log(lines[i] + ' = ' + best_word);
        }

    }

    var get_best_word = function(letters, dictionary){
        var best_word = '';
        for(var i=0; i<dictionary.length; i++){
            var is_good_word = true;

            for(j=0; j<dictionary[i].length; j++){
                if (letters.indexOf(dictionary[i][j]) == -1){
                    is_good_word = false;
                }
            }
            if(is_good_word && dictionary[i].length > best_word.length){
                best_word = dictionary[i];
            }
        }
        return best_word;
    }

    process.stdin.resume();
    process.stdin.setEncoding('utf8');
    process.stdin.on('data', function(data) {
        process_input(data);
    });


