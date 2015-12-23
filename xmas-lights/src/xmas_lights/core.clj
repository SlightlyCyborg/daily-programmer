(ns xmas-lights.core)

(def light-voltage 1.7)
(def light-amperage  20)

(def bat-voltage 9)
(def bat-cap 1200) ;in mAh

(defn max-in-serial [b-v l-v]
  (Math/floor (/ b-v l-v)) )

(defn how-many-lights 
  [time-to-run] ;in h
  (/ (* (/ bat-cap light-amperage) (max-in-serial bat-voltage light-voltage)) time-to-run))


