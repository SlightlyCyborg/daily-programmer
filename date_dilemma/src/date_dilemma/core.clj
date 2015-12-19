(ns date-dilemma.core)

(defn parse-date [d]
  (let [p-date 
   (re-seq #"[0-9]+" d)]
    (if (= 4 (count (first p-date)))
      (str (first p-date) "-" (second p-date) "-" (last p-date))
      (if (= 4 (count (last p-date)))
      (str (last p-date) "-" (first p-date) "-" (second p-date))
      (if (< (Integer/parseInt (last p-date)) 30)
        (str "20"(last p-date) "-" (first p-date) "-" (second p-date))
        (str "19"(last p-date) "-" (first p-date) "-" (second p-date)))))))


