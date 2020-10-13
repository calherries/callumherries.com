(defn form-3-reagent-sub-comp [title]
  (let [secs* (r/atom 0)
        id*   (atom nil)]
    (r/create-class
      {:display-name "form-3-reagent-sub-comp"
       :component-did-mount
       (fn []
         (->> (js/setInterval #(swap! secs* inc)
                              1000)
              (reset! id*)))
       :component-will-unmount
       (fn []
         (js/clearInterval @id*))
       :reagent-render
       (fn [title]
         [:div.card
          [:div.card-body
           [:h5.card-title
            title]
           [:p.card-text
            (str "Tab opened for " @secs* " seconds")]]])})))

(defn form-3-tiny-wrapper-sub-comp [props]
  (let [{:keys [title]} (js->clj props :keywordize-keys true)
        [secs set-secs] (js/React.useState 0)] ;; uses (r/atom 0) in the let block
    (js/React.useEffect
      (fn start-timer [] ;; component-did-mount
        (let [secs* (atom secs) ;; in the let block at the top
              id    (js/setInterval #(-> secs* (swap! inc) set-secs)
                                    1000)]
          (fn stop-timer []
            (js/clearInterval id))))
      #js [])
    (div {:className "card"}
         (div {:className "card-body"}
              (h5 {:className "card-title"}
                  title)
              (p {:className "card-text"}
                 (str "Tab opened for " secs " seconds"))))))
