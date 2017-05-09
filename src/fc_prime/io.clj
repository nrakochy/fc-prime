(ns fc-prime.io
  (:require [clojure.string :refer [join]]))

(defn render [coll]
  (->> coll (join (System/lineSeparator)) println))
