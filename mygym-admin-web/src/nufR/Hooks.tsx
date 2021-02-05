import { useEffect, useState } from "react";
import { defaultConfig } from "./pages/ListPage";
import { INUFRConfig } from "./pages/ListPage";

export function useNUFRConfig(configname: string) {

    const [loading, setLoading] = useState(true);
    const [config, setConfig] = useState<INUFRConfig>(defaultConfig);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            import("../nufrConfig/" + configname + "Config").then(c => {
                setConfig(c.default);
                console.log('confg loaded!');
                setLoading(false);
            });
        };
        fetchData();
    }, []);

    return { config, loading } as const;
}
