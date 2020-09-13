(ns callumherries.routes
  (:require [callumherries.posts :as posts]))

(def posts-routes
  ["posts/" (into []
                  (for [{:keys [page-key]} posts/posts-data]
                    [(str (name page-key) ".html") page-key]))])

(def routes
  ["/" [["index.html" :page/index]
        ["about.html" :page/about]
        posts-routes]])
