package compareDNA;

public class translation {
    public String[] translater(String x) {
        int aminosLength = (int) (x.length() / 3);
        int counter = 0;
        String[] allAminos = new String[aminosLength];
        while (counter < aminosLength) {
        for (int i = 0; i < x.length(); i = i + 3) {
                // if statements for now, mapping in future.
                if (x.charAt(i) == 'G') { // If the first is G.
                    if (x.charAt(i + 1) == 'U') {
                        allAminos[counter] = "Valine";
                        counter++;
                    }
                    if (x.charAt(i + 1) == 'C') {
                        allAminos[counter] = "Alanine";
                        counter++;
                    }
                    if (x.charAt(i + 1) == 'A') {
                        if (x.charAt(i + 2) == 'U' || x.charAt(i + 2) == 'C') {
                            allAminos[counter] = "Aspartic acid";
                            counter++;
                        }
                        if (x.charAt(i + 2) == 'A' || x.charAt(i + 2) == 'G') {
                            allAminos[counter] = "Glutamic acid";
                            counter++;
                        }
                    }
                    if (x.charAt(i + 1) == 'G') {
                        allAminos[counter] = "Glycine";
                        counter++;
                    }
                }
                if (x.charAt(i) == 'U') { //If the first letter is U
                    if (x.charAt(i + 1) == 'U') {
                        if (x.charAt(i + 2) == 'U' || x.charAt(i + 2) == 'C') {
                            allAminos[counter] = "Phenylalanine";
                            counter++;
                        }
                        if (x.charAt(i + 2) == 'A' || x.charAt(i + 2) == 'G') {
                            allAminos[counter] = "Leucine";
                            counter++;
                        }
                    }
                    if (x.charAt(i + 1) == 'C') {
                        allAminos[counter] = "Serine";
                        counter++;
                    }

                    if (x.charAt(i + 1) == 'A') {
                            if (x.charAt(i + 2) == 'U' || x.charAt(i + 2) == 'C') {
                                allAminos[counter] = "Tyrosine";
                                counter++;
                            }
                            if (x.charAt(i + 2) == 'A' || x.charAt(i + 2) == 'G') {
                                allAminos[counter] = "Stop";
                                counter++;
                            }
                        }
                        if (x.charAt(i + 1) == 'G') {
                            if (x.charAt(i + 2) == 'U' || x.charAt(i + 2) == 'C') {
                                allAminos[counter] = "Cysteine";
                                counter++;
                            }
                            if (x.charAt(i + 2) == 'A') {
                                allAminos[counter] = "Stop";
                                counter++;
                            }
                            if (x.charAt(i + 2) == 'G') {
                                allAminos[counter] = "Tryptophan";
                                counter++;
                            }
                        }
                    }
                    if (x.charAt(i) == 'C') { // If the first is G.
                        if (x.charAt(i + 1) == 'U') {
                            allAminos[counter] = "Leucine";
                            counter++;
                        }
                        if (x.charAt(i + 1) == 'C') {
                            allAminos[counter] = "Proline";
                            counter++;
                        }
                        if (x.charAt(i + 1) == 'A') {
                            if (x.charAt(i + 2) == 'U' || x.charAt(i + 2) == 'C') {
                                allAminos[counter] = "Histidine";
                                counter++;
                            }
                            if (x.charAt(i + 2) == 'A' || x.charAt(i + 2) == 'G') {
                                allAminos[counter] = "Glutamine";
                                counter++;
                            }
                        }
                        if (x.charAt(i + 1) == 'G') {
                            allAminos[counter] = "Arginine";
                            counter++;
                        }
                    }
                    if (x.charAt(i) == 'A') { // If the first is G.
                        if (x.charAt(i + 1) == 'C') {
                            allAminos[counter] = "Threonine";
                            counter++;
                        }
                        if (x.charAt(i + 1) == 'U') {
                            if (x.charAt(i + 2) == 'G') {
                                allAminos[counter] = "Methionine";
                                counter++;
                            }
                            if (x.charAt(i + 2) == 'A' || x.charAt(i + 2) == 'U'|| x.charAt(i + 2) == 'C') {
                                allAminos[counter] = "Isoleucine";
                                counter++;
                            }
                        }
                        if (x.charAt(i + 1) == 'A') {
                            if (x.charAt(i + 2) == 'U' || x.charAt(i + 2) == 'C') {
                                allAminos[counter] = "Asparagine";
                                counter++;
                            }
                            if (x.charAt(i + 2) == 'A' || x.charAt(i + 2) == 'G') {
                                allAminos[counter] = "Lysine";
                                counter++;
                            }
                        }
                        if (x.charAt(i + 1) == 'G') {
                            if (x.charAt(i + 2) == 'U' || x.charAt(i + 2) == 'C') {
                                allAminos[counter] = "Serine";
                                counter++;
                            }
                            if (x.charAt(i + 2) == 'A' || x.charAt(i + 2) == 'G') {
                                allAminos[counter] = "Arginine";
                                counter++;
                            }
                        }
                    }
                }
            
        }
        return allAminos;
    
}
}