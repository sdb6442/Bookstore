/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baynessamuelproject3;

/**
 * CD class extends Inventory class
 * for Project 3
 * @author Samuel Baynes
 */
public class CD extends Inventory {
    private int chartRanking;
    private String band;
    
    /**
     * CD Constructor, specific parameters for CDs
     * @param _title CD Title
     * @param _band Band Name
     * @param _price Price
     * @param _amount Amount in Inventory
     * @param _yearReleased Year Released
     * @param _itemNum Item ID Number
     * @param _chartRanking Peak Position on the US Chart
     */
    public CD (String _title, String _band, double _price, int _amount, int _yearReleased, int _itemNum, int _chartRanking)
    {
            super(_title, _price, _amount, _yearReleased, _itemNum);
            this.band = _band;
            this.chartRanking = _chartRanking;
    }
    
     /**
     * Get the CD's band name.
     * @return Band name
     */
    public String getBand()
    {
        return band;
    }
    
    /**
     * Sets the Band of the CD.
     * @param _band Band of the CD.
     */
    public void setAuthor(String _band)
    {
        band = _band;
    }
    
     /**
     * Get the CD's high on the Billboard chart ranking.
     * @return CD chart ranking
     */
    public int getChartRanking()
    {
        return chartRanking;
    }
    
    /**
     * Sets the CD's high on the Billboard Chart Ranking.
     * @param _chartRanking.
     */
    public void setChartRanking(int _chartRanking)
    {
        chartRanking = _chartRanking;
    }
    
    /**
    * Overrides the Inventory toString() to display additional information
    * relevant to CDs.
    * @return CD information
    */
    @Override
    public String toString()
    {
        return this.getTitle() + ", by " + this.getBand() + "\n\t Peak Position on the US Charts: " + this.getChartRanking()+
            "\n\t Release Date: " + this.getYearReleased() + "\n\t Price: $" + this.getPrice() + "\n\t ID Number: " +
            this.getItemNum() + "\n\t Copies Available: " + this.getAmount() + "\n";
    }
}
