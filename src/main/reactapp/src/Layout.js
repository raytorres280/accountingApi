import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import CssBaseline from '@mui/material/CssBaseline';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Typography from '@mui/material/Typography';
import Divider from '@mui/material/Divider';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import StoreIcon from '@mui/icons-material/Store';
import LocalConvenienceStoreIcon from '@mui/icons-material/LocalConvenienceStore';
import { Link, Routes, Route, useLocation } from 'react-router-dom'
import ExamplePage from './ExamplePage';
import Vendors from './Vendors';
import Distributors from './Distributors';

const drawerWidth = 180;



export default function Layout() {
    const location = useLocation()
    console.log(location.pathname)
  return (
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <AppBar
        position="fixed"
        sx={{ width: `calc(100% - ${drawerWidth}px)`, ml: `${drawerWidth}px` }}
      >
        <Toolbar>
          <Typography variant="h6" noWrap component="div">
            {location.pathname.replace("/", "")}
          </Typography>
        </Toolbar>
      </AppBar>
      <Drawer
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          '& .MuiDrawer-paper': {
            width: drawerWidth,
            boxSizing: 'border-box',
          },
        }}
        variant="permanent"
        anchor="left"
      >
        <Toolbar />
        <Divider />
        <List>
          {['vendors', 'distributors'].map((text, index) => (
            <Link to={text}>
                <ListItem key={text} disablePadding>
                    <ListItemButton>
                        <ListItemIcon>
                        {index % 2 === 0 ? <StoreIcon /> : <LocalConvenienceStoreIcon />}
                        </ListItemIcon>
                        <ListItemText primary={text} />
                    </ListItemButton>
                </ListItem>
            </Link>
          ))}
        </List>
        <Divider />
      </Drawer>
      <Box
        component="main"
        sx={{ flexGrow: 1, bgcolor: 'background.default', p: 3 }}
      >
        <Routes>
                <Route path="/" element={<ExamplePage />} />
                <Route path="vendors" element={<Vendors />} />
                <Route path="distributors" element={<Distributors />} />
        </Routes>
      </Box>
    </Box>
  );
}


