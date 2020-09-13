(ns callumherries.pages.posts
  (:require [markdown-to-hiccup.core :as m]
            [callumherries.components :as components]
            [callumherries.posts :as posts]
            [shadow.resource :as rc]))

(def posts
  (->> posts/posts-data
       (sort-by :date (complement compare)) ;; order by descending date
       (map #(assoc % :hiccup [:div.post (->> %
                                              :md
                                              m/md->hiccup
                                              m/component
                                              (drop 3)
                                              (cons [:p.text-xs.font-mono.text-gray-500.mt-1 (:date %)])
                                              (cons [:h1.font-mono (:title %)]))]))))
