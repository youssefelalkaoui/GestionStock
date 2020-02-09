package com.stock.gestion.dao;

import java.util.List;

import com.stock.gestion.entites.LigneCommandeClient;


public interface ILigneCommandeClientDao extends IGenericDao<LigneCommandeClient> {
      public List<LigneCommandeClient> getByIdCommande(Long idCommandeClient);
}
