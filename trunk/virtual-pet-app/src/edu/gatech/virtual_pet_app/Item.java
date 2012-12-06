package edu.gatech.virtual_pet_app;

public class Item {
	private int item_id;
	private String description;
	private int price;
	private int impact;
	private String illnessImpact;
	private int quantity;
	private Type type;
	public enum Type {FOOD,TOY,MEDICINE};
	
	public Item(int item_id, int price,String description, Type t, int impact, String sick){
		this.item_id=item_id;
		this.description=description;
		this.price=price;
		this.impact = impact;
		illnessImpact=sick;
		type=t;
		quantity = 1;
	}
	public Item()
	{
		

	}
	public int getPrice()
	{
		return this.price;
	}
	
	public int getImpact()
	{
		return this.impact;
	}
	
	public String getIllnessImpact()
	{
		return this.illnessImpact;
	}
	public String getDescription()
	{
		return this.description;
	}
	public Type getType()
	{
		return type;
	}
	public int getQuantity()
	{
		return this.quantity;
	}
	public void setQuantity(int num)
	{
		this.quantity = num;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setImpact(int impact) {
		this.impact = impact;
	}
	public void setIllnessImpact(String illnessImpact) {
		this.illnessImpact = illnessImpact;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String toString(){
		return getDescription()+": $"+getPrice();
	}
	
}
