(ns loja.aula3
(:require [loja.db :as l.db]))
; :require me permite acessar outros namespaces
(println (l.db/todos-os-pedidos))

(println (group-by :usuario-id (l.db/todos-os-pedidos)))

(defn minha-funcao-de-agrupamento
  [elemento]
  (println "elemento" elemento)
  (:usuario-id elemento))

(println (group-by minha-funcao-de-agrupamento (l.db/todos-os-pedidos)))

(println (map count (vals (group-by :usuario-id (l.db/todos-os-pedidos)))))

(->> (l.db/todos-os-pedidos)
     (group-by :usuario-id)
     vals
     (map count)
     println
     )

(defn conta-total-por-usuario
  [[usuario pedidos]]
  (count pedidos)
  )
;retorna quantidade de pdidos
(->> (l.db/todos-os-pedidos)
(group-by :usuario-id)
(map conta-total-por-usuario)
println
)
;retorna como um vetor
(defn conta-total-por-usuario
  [[usuario pedidos]]
  [usuario (count pedidos)]
  )

(->> (l.db/todos-os-pedidos)
     (group-by :usuario-id)
     (map conta-total-por-usuario)
     println
     )

; retorna como um dicionario/mapa
(defn conta-total-por-usuario
  [[usuario pedidos]]
  {
   :usuario-id usuario
   :total      (count pedidos)
   }
  )

(->> (l.db/todos-os-pedidos)
     (group-by :usuario-id)
     (map conta-total-por-usuario)
     println
     )


(defn total-do-item
  [[item-id detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0))
  )

(defn total-do-pedido
  [pedido]
  (println pedido)
  (reduce + (map total-do-item pedido))
  )

(defn total-dos-pedidos
  [pedidos]
 (->> pedidos
      (map :itens)
      (map total-do-pedido)
      (reduce +)))

(defn quantia-de-pedidos-e-gasto-total-por-usuario
  [[usuario pedidos]]
  {
   :usuario-id  usuario
   :total       (count pedidos)
   :preco-total (total-dos-pedidos pedidos)
   }
  )

(->> (l.db/todos-os-pedidos)
     (group-by :usuario-id)
     (map quantia-de-pedidos-e-gasto-total-por-usuario)
     println
     )