(ns random-bag.core)


(defn new-bag [] ["O" "I" "S" "Z" "L" "J" "T" ]) 

(defn choose-from-bag [bag]
  (let [item (rand-nth bag)]
    (print item)
    (remove (fn [x] (= x item)) bag)))

(defn pick-x [x]
  (loop [y 0 bag (new-bag)]
    (if (< y x)
      (if (= 1 (count bag))
        (do  (choose-from-bag bag) (recur (+ y 1) (new-bag)))
        (recur (+ y 1) (choose-from-bag bag))))))



