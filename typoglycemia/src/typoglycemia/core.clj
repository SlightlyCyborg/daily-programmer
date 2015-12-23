(ns typoglycemia.core)



(defn shuffle-str [st] 
  (apply str (shuffle (seq st))))


(let [i  "According to a research team at Cambridge University, it doesn't matter in what order the letters in a word are, the only important thing is that the first and last letter be in the right place.  The rest can be a total mess and you can still read it without a problem. This is because the human mind does not read every letter by itself, but the word as a whole.  Such a condition is appropriately called Typoglycemia."]
  (apply str (interleave (map (fn [x] (if (> (count x) 2)
                           (str (first x) (shuffle-str (subs x 1 (- (count x) 1))) (last x))
                           x)) 
      (clojure.string/split i #" ")) (repeat " ")))) 

