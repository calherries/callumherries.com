(ns callumherries.build
  (:require [volcano.build :as build]
            [callumherries.config :as config]))

(defn -main [& args]
  (build/build-web! (config/config)))
