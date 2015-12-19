(ns app.core
  (:gen-class))

(defn load_map
  []
    (slurp "boxes.txt"))

(defn find_boxes
  [map]
  (doseq 
    [box_str [map]]
    (println box_str)
    (doseq
      [letter [box_str]]
      (println letter)      
    )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [map (load_map)]
    (find_boxes
        (clojure.string/split-lines map))))
