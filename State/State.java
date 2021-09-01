/**
 * The State class recieves tokens from DataReader
 * and stores that information so it can be called
 * later in ChartWindow
 *
 * @author (seant01)
 * @version (12.4.20)
 */
public class State
{
    private String names = "";
    private int infections = 0;
    private int deaths = 0;
    /**
     * @param name is the name of the state.
     * @param infection is the number of 
     * infections in the state.
     * @param death is the number of deaths
     * due to COVID in the state.
     */
    public State(String name, int infection, int death)
    {
        names = name;
        infections = infection;
        deaths = death;
    }
    /**
     * @return returns the State's name.
     */
    public String getStateName()
    {
        return this.names;
    }
    /**
     * @return returns the number of infections
     * in a state.
     */
    public int getInfections()
    {
        return this.infections;  
    }
    /**
     * @return returns the number of deaths in
     * a state.
     */
    public int getDeaths()
    {
        return this.deaths;
    }
}
