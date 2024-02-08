create or replace view v_besoin_achat_en_nature(
select
id_produit,count(*)
from Demande_Produit
join Besoin_Achat
on Besoin_Achat.id_Besoin_Achat=Demande_Produit.id_besoin_achat
join Produit
on Produit.id_Produit=Demande_Produit.id_produit
group by
id_produit
)