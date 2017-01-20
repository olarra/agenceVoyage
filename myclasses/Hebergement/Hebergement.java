package hebergement;

/**
 * A class for representing a product. A product consists of a name, a price per kg, and a
 * weight (in kgs, meant to be the available amount of this product).
 * @author Bruno Zanuttini, Universit&eacute; de Caen Basse-Normandie, France.
 * @since January, 2013
 */
public class Hebergement {
  protected int idHebergement;
  protected String  type;
  protected String  pays;
  protected String  surface;
  protected String  npieces;
  protected String  addresse;
  protected String  terrain_exterieur;
  protected String  description;
  protected String  image;

  public Hebergement () {
        this(0,"","","","","","","","");
      }

  public Hebergement (int idHebergement, String type, String pays, String surface, String npieces, String addresse, String terrain_exterieur, String description, String image) {
        this.idHebergement=idHebergement;
        this.type=type;
        this.pays=pays;
        this.surface=surface;
        this.npieces=npieces;
        this.addresse=addresse;
        this.terrain_exterieur=terrain_exterieur;
        this.description=description;
        this.image=image;
    }

  public Hebergement (Hebergement hebergement) {
       this(hebergement.getIdHebergement(),hebergement.getType(),hebergement.getPays(),hebergement.getSurface(),hebergement.getNpieces(),hebergement.getAddresse(), hebergement.getTerrain_exterieur(), hebergement.getDescription(),hebergement.getImage());
    }

  /**
  * Create string representation of for for printing
  * @return
	*/
  @Override
  public String toString() {
  	return "for [type=" + type + ", pays=" + pays + ", surface=" + surface + ", npieces=" + npieces + ", addresse=" + addresse + ", terrain_exterieur=" + terrain_exterieur + "]";
  }

  /**
  * Returns value of type
  * @return
  */
  public int getIdHebergement() {
    return idHebergement;
  }
  	/**
	* Returns value of type
	* @return
	*/
	public String getType() {
		return type;
	}

	/**
	* Sets new value of type
	* @param
	*/
	public void setType(String type) {
		this.type = type;
	}

	/**
	* Returns value of pays
	* @return
	*/
	public String getPays() {
		return pays;
	}

	/**
	* Sets new value of pays
	* @param
	*/
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	* Returns value of surface
	* @return
	*/
	public String getSurface() {
		return surface;
	}

	/**
	* Sets new value of surface
	* @param
	*/
	public void setSurface(String surface) {
		this.surface = surface;
	}

	/**
	* Returns value of npieces
	* @return
	*/
	public String getNpieces() {
		return npieces;
	}

	/**
	* Sets new value of npieces
	* @param
	*/
	public void setNpieces(String npieces) {
		this.npieces = npieces;
	}

	/**
	* Returns value of addresse
	* @return
	*/
	public String getAddresse() {
		return addresse;
	}

	/**
	* Sets new value of addresse
	* @param
	*/
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	/**
	* Returns value of terrain_exterieur
	* @return
	*/
	public String getTerrain_exterieur() {
		return terrain_exterieur;
	}

	/**
	* Sets new value of terrain_exterieur
	* @param
	*/
	public void setTerrain_exterieur(String terrain_exterieur) {
		this.terrain_exterieur = terrain_exterieur;
	}

  /**
  * Returns value of description
  * @return
  */
  public String getDescription() {
    return description;
  }

  /**
  * Sets new value of terrain_exterieur
  * @param
  */
  public void setDescription(String description) {
    this.description = description;
  }


  /**
  * Returns value of image
  * @return
  */
  public String getImage() {
    return image;
  }

  /**
  * Sets new value of image
  * @param
  */
  public void setImage(String image) {
    this.image = image;
  }


}
