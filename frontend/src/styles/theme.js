import { createTheme } from "@mui/material/styles";

const theme = createTheme({
  palette: {
    primary: {
        main: "#F3F7F9",
        contrast:"#17ACFA" 
    },
    secondary: {
      main: "#13171A",
    },
    error: {
      main: "#617788",
    },
    warning: {
      main: "#A7B8C3",
    },
    info: {
      main: "#DFE8EE",
    },
    success: {
      main: "#F3F7F9",
    },
  },
});

export default theme;