(ns fruit-buy.core)
(require '[clojure.string :as str])

(defn parse_input [input] 
  (map (fn [line] 
    (str/split line #" ")) 
  (clojure.string/split-lines input)))

(defn gen_sortlist [sortfn pos]
  (comparator (fn [item1 item2] 
    (if (sortfn (read-string (get item1 pos)) (read-string (get item2 pos)))
      item1
      item2))))

(defn preprocess_input [input]
  (map (fn [pair] (list (first pair) (read-string (last pair)))) (sort (gen_sortlist > 1) input)))

(defn find-fruit-combos [fruit-list cents-left]
  ;Termination condition
  (if (< cents-left (last (last fruit-list)))
    (list (list))
    ;We now want to go through the entire fruit list. If the item is purchaseable, then put it in a list and conj it to find-fruit-combo
    (mapcat (fn [cur-test-fruit]
      (if (<= (last cur-test-fruit) cents-left)
        (let [rv (map 
          (fn [instance] (do 
                           ;(println instance) 
                           (cons cur-test-fruit instance)))
          (find-fruit-combos fruit-list (- cents-left (last cur-test-fruit))))]
          (do 
            ;(println cur-test-fruit)
            ;(println rv)
            rv))
        (list)))
    fruit-list)))

(def input1 
  "banana 32\nkiwi 41\nmango 97\npapaya 254\npineapple 399")

;(def parsed-input (preprocess_input (parse_input input1)))

;(find-fruit-combos parsed-input 500)

(defn main []
  (def parsed-input (preprocess_input (parse_input input1)))
  (println (find-fruit-combos parsed-input 500))
  )
