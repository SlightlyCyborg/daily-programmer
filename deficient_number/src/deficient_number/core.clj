(ns deficient_number.core)

(defn get-divisors [x]
  (filter (fn [y] (if (= 0 (mod x y))
                    true
                    false)) 
          (range 1 (+ x 1))))

(defn abundant-or-deficient [x]
  (let [div-sum (reduce + (get-divisors x))]
    (if (= div-sum (* 2 x))
      "neither" 
      (if (< div-sum (* 2 x))
        "deficient"
        (str "abundant by " (- div-sum (* 2 x)))))))


(def data [111 112 220 69 134 85])

(defn main []
 (doseq [d data] (println (str d " " (abundant-or-deficient d)))))

(main)
