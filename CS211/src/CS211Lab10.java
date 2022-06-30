import java.util.Arrays;

public class CS211Lab10
{
    public static void main(String[] args)
    {
        int numOfCoords = 39;
        double[][] distances = new double[numOfCoords][numOfCoords];
        double[][] Coords = {
                {51.62497513,-8.887028344}, {51.94026835,-10.24088642}, {52.178285,-8.911617}, {52.268, -7.0945}, {52.33356304,-6.463963364},
                {52.4736608,-8.4346524}, {52.86618127,-6.942840109}, {52.909722,-6.839167}, {53.1699938,-6.914885591}, {53.17901778,-7.719844209},
                {53.18436564,-6.792525445}, {53.19490793,-6.670261667}, {53.1953312,-6.670313902}, {53.21575053,-6.661529073},
                {53.27663886,-6.48044077}, {53.29179685,-6.698044529}, {53.31827917,-6.389738373}, {53.32421,-6.33366}, {53.33655618,-6.462126917},
                {53.3579,-6.441}, {53.36407274,-6.498749584}, {53.36838522,-6.274938564}, {53.37006,-6.58208}, {53.3717,-6.3905}, {53.37484,-6.40909},
                {53.3888,-6.39608}, {53.389153,-6.169552409}, {53.3945937,-6.5985973}, {53.3977573,-6.4348173}, {53.50413322,-6.387552494},
                {53.52695407,-7.346691823}, {53.552384,-6.790148}, {53.64314,-6.64577}, {53.80115134,-9.512749602}, {54.1795236,-7.225463119},
                {54.26405697,-6.956248402}, {54.648672,-8.112425}, {54.655499,-8.632717}, {55.09671038,-8.278657422}
        };
        //System.out.println(distance(Coords[0][0],Coords[0][1],Coords[1][0],Coords[1][1]));

        for(int i=0;i<numOfCoords;i++)
        {
            for(int j=0;j<numOfCoords;j++)
            {
                double lat1 = Coords[i][0];
                double lon1 = Coords[i][1];
                double lat2 = Coords[j][0];
                double lon2 = Coords[j][1];
                //distances[0][1] would store the distance between the first school and the second
                distances[i][j] = distance(lat1,lon1,lat2,lon2);
            }
            Arrays.sort(distances[i]);//sort the sub array
        }

        // find the tenth smallest one
        double tenthSmallest = distances[0][10];
        int index = 0;
        for(int i = 0; i<numOfCoords;i++)
        {
            if(tenthSmallest>distances[i][10])
            {
                tenthSmallest = distances[i][10];
                index = i;
            }
        }

        System.out.println(tenthSmallest);
        System.out.println(Coords[index][0]+" "+Coords[index][1]);
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2)
    {
        // degrees to radians.
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // radius of earth in kilometers
        double r = 6371;

        // calculate the result
        return(c * r);
    }
}
