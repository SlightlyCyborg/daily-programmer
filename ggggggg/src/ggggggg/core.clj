(ns ggggggg.core)

(defn ggg-to-english-dict [key]
  (clojure.set/map-invert (apply assoc {} (clojure.string/split key #" "))))

(defn decode [text]
  (let [dict (ggg-to-english-dict (first (clojure.string/split-lines text))) 
        text (second (clojure.string/split-lines text))]
   (loop [begin 0 end 1 word ""]
     (if (> end (count text))
      word
      (if (= nil (re-matches #"[Gg]+" (subs text begin end)))
        (recur (+ 1 begin) (+ 1 end) (str word " "))
        (if (contains? dict (subs text begin end))
          (recur end (+ 1 end) (str word (dict (subs text begin end))))
          (recur begin (+ 1 end) word)))))))

(print (slurp "input.txt"))
(print (decode (slurp "input.txt")))

